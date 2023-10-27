package org.example.dao;

import org.example.model.Client;
import org.example.model.Order;

/**
 * This class represents a Data Access Object(DAO) for the {@link Order} model.
 * It provides methods to interact with the database and perform CRUD operations on order objects.
 * Extends the {@link AbstractDAO} class to inherit common database operations.
 */
public class OrderDAO extends AbstractDAO<Order> {
    /**
     * Constructs a new OrderDAO object.
     * Initializes the superclass with no parameters.
     */
    public OrderDAO() {
        super();
    }
}
