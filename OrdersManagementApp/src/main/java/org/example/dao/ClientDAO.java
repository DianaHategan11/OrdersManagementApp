package org.example.dao;

import org.example.model.Client;

/**
 * This class represents a Data Access Object(DAO) for the {@link Client} model.
 * It provides methods to interact with the database and perform CRUD operations on client objects.
 * Extends the {@link AbstractDAO} class to inherit common database operations.
 */
public class ClientDAO extends AbstractDAO<Client> {
    /**
     * Constructs a new ClientDAO object.
     * Initializes the superclass with no parameters.
     */
    public ClientDAO() {
        super();
    }
}
