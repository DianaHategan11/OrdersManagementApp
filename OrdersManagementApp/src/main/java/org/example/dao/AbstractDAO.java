package org.example.dao;

import org.example.connection.ConnectionFactory;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generic DAO (Data Access Object) for performing common database operations.
 *
 * @param <T> the type of the objects stored in the database
 */
public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
    private final Class<T> type;

    /**
     * Constructs a new instance of the AbstractDAO class.
     * Automatically determines the type of the objects based on the generic superclass.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Creates the SQL query for selecting all objects of type T.
     *
     * @return the SQL query String
     */
    public String createSelectAllQuery() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        stringBuilder.append(" * ");
        stringBuilder.append(" FROM ordersdb.");
        stringBuilder.append(type.getSimpleName().toLowerCase());
        return stringBuilder.toString();
    }

    /**
     * Retrieves all objects of type T from the database.
     *
     * @return a list of all objects
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Creates the SQL query for selecting an object of type T by id.
     *
     * @param field the name of the id field
     * @param id    the id value
     * @return the SQL query String
     */
    public String createSelectQuery(String field, int id) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        stringBuilder.append(" * ");
        stringBuilder.append(" FROM ordersdb.");
        stringBuilder.append(type.getSimpleName().toLowerCase());
        stringBuilder.append(" WHERE ").append(field).append(" = ").append(id);
        return stringBuilder.toString();
    }

    /**
     * Retrieves an object of type T from the database by id.
     *
     * @param id the id value
     * @return the object with the specified id, or null if not found
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Field[] fields = type.getDeclaredFields();
        String query = createSelectQuery(fields[0].getName(), id);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Creates objects of type T based on the data retrieved from the database.
     *
     * @param resultSet the result set containing the data
     * @return a list of created objects
     */
    @SuppressWarnings("unchecked")
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                assert ctor != null;
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add((T) instance);
            }
        } catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException |
                 InvocationTargetException | SQLException | IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Generates a JTable from a list of objects.
     *
     * @param tList the list of objects
     * @return the generated JTable
     */
    public JTable generateTable(List<T> tList) {
        Field[] fields = tList.get(0).getClass().getDeclaredFields();
        String[] columns = new String[fields.length];
        int index = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            columns[index++] = field.getName();
        }
        Object[][] table = new Object[tList.size()][fields.length];
        for (int i = 0; i < tList.size(); i++) {
            T t = tList.get(i);
            for (int j = 0; j < fields.length; j++) {
                try {
                    Field field = fields[j];
                    field.setAccessible(true);
                    table[i][j] = field.get(t);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(table, columns);
        JTable jTable = new JTable(defaultTableModel);
        return jTable;
    }

    /**
     * Inserts an object into the database.
     *
     * @param t the object to insert
     * @return the inserted object, or null if the operation failed
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        int length = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT ");
        stringBuilder.append(" INTO ordersdb.");
        stringBuilder.append(type.getSimpleName().toLowerCase()).append("(");
        try {
            connection = ConnectionFactory.getConnection();
            for (Field field : t.getClass().getDeclaredFields()) {
                length++;
                field.setAccessible(true);
                stringBuilder.append(field.getName());
                if (length < t.getClass().getDeclaredFields().length) {
                    stringBuilder.append(", ");
                } else {
                    stringBuilder.append(")");
                }
            }
            length = 0;
            stringBuilder.append(" VALUES ").append("(");
            for (Field field : t.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                length++;
                Object value;
                value = field.get(t);
                if (value instanceof String) {
                    stringBuilder.append("'").append(value).append("'");
                } else {
                    stringBuilder.append(value);
                }
                if (length < t.getClass().getDeclaredFields().length) {
                    stringBuilder.append(", ");
                } else {
                    stringBuilder.append(")");
                }
            }
            String query = stringBuilder.toString();
            statement = connection.prepareStatement(query);
            statement.execute(query);
            return t;
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Updates an object in the database.
     *
     * @param t the object to update
     * @return the updated object, or null if the operation failed
     */
    public T update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        Field[] fields = t.getClass().getDeclaredFields();
        int length = 0, id = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE ");
        stringBuilder.append(type.getSimpleName().toLowerCase());
        stringBuilder.append(" SET ");
        try {
            connection = ConnectionFactory.getConnection();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value;
                value = field.get(t);
                length++;
                if (length == 1) {
                    id = (int) value;
                }
                stringBuilder.append(field.getName()).append(" = ");
                if (value instanceof String) {
                    stringBuilder.append("'").append(value).append("'");
                } else {
                    stringBuilder.append(value);
                }
                if (length < t.getClass().getDeclaredFields().length) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append(" WHERE ").append(fields[0].getName()).append(" = ").append(id);
            String query = stringBuilder.toString();
            statement = connection.prepareStatement(query);
            statement.execute(query);
            return t;
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Creates the SQL delete query based on the specified field and id.
     *
     * @param field the name of the id field
     * @param id    the id value
     * @return the delete query
     */
    private String createDeleteQuery(String field, int id) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE ");
        stringBuilder.append(" FROM ");
        stringBuilder.append(type.getSimpleName().toLowerCase());
        stringBuilder.append(" WHERE ").append(field).append(" = ").append(id);
        return stringBuilder.toString();
    }

    /**
     * Deletes a row from the database based on the specified id.
     *
     * @param id the id value
     */
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Field[] fields = type.getDeclaredFields();
        String query = createDeleteQuery(fields[0].getName(), id);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.execute(query);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }
}
