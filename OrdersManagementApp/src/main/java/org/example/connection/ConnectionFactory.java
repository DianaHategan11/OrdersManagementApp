package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The ConnectionFactory class is responsible for establishing connections to the database and closing database resources.
 * It uses the Singleton pattern to ensure a single instance of the factory is created.
 */
public class ConnectionFactory {
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/ordersdb";
    private static final String USER = "root";
    private static final String PASS = "Dienuk11";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * Initializes the MySQL JDBC driver.
     */
    public ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new database connection.
     *
     * @return the newly created database connection
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Retrieves a database connection.
     *
     * @return a database connection
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Closes the given database connection.
     *
     * @param connection the database connection to close
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }

    /**
     * Closes the given database statement.
     *
     * @param statement the database statement to close
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }

    /**
     * Closes the given ResultSet.
     *
     * @param resultSet the ResultSet to close
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }
}
