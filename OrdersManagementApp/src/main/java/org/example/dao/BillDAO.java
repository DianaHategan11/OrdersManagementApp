package org.example.dao;

import org.example.connection.ConnectionFactory;
import org.example.model.Bill;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * This class represents a Data Access Object (DAO) for the {@link Bill} model.
 * It provides methods to interact with the database and perform CRUD operations on bill objects.
 * Extends the {@link AbstractDAO} class to inherit common database operations.
 */
public class BillDAO extends AbstractDAO<Bill> {
    /**
     * Constructs a new BillDAO object.
     * Initializes the superclass with no parameters.
     */
    public BillDAO() {
        super();
    }

    /**
     * Retrieves all the bills from the database.
     *
     * @return a list of all the bills, or null if the operation failed
     */
    public List<Bill> findAllBills() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Bill> listOfBills = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        stringBuilder.append(" * ");
        stringBuilder.append(" FROM ordersdb.");
        stringBuilder.append("bill");
        String query = stringBuilder.toString();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int billId = resultSet.getInt(1);
                String clientName = resultSet.getString(2);
                String emailAddress = resultSet.getString(3);
                String productName = resultSet.getString(4);
                int quantity = resultSet.getInt(5);
                double totalPrice = resultSet.getDouble(6);
                Bill newBill = new Bill(billId, clientName, emailAddress, productName, quantity, totalPrice);
                listOfBills.add(newBill);
            }
            return listOfBills;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "bill" + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
