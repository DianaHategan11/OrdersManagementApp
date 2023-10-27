package org.example.dao;

import org.example.model.Order;
import org.example.model.Product;

/**
 * This class represents a Data Access Object(DAO) for the {@link Product} model.
 * It provides methods to interact with the database and perform CRUD operations on product objects.
 * Extends the {@link AbstractDAO} class to inherit common database operations.
 */
public class ProductDAO extends AbstractDAO<Product> {
    /**
     * Constructs a new ProductDAO object.
     * Initializes the superclass with no parameters.
     */
    public ProductDAO() {
        super();
    }
}
