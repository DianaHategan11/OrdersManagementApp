package org.example.bll;

import org.example.bll.validators.ClientAgeValidator;
import org.example.bll.validators.EmailValidator;
import org.example.bll.validators.Validator;
import org.example.dao.ClientDAO;
import org.example.model.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The ClientBLL class is responsible for handling business logic operations related to clients.
 */
public class ClientBLL {
    private ClientDAO clientDAO;
    private List<Validator<Client>> validators;

    /**
     * Constructs a new ClientBLL object and initializes the clientDAO and validators.
     */
    public ClientBLL() {
        this.clientDAO = new ClientDAO();
        validators = new ArrayList<Validator<Client>>();
        validators.add(new ClientAgeValidator());
        validators.add(new EmailValidator());
    }

    /**
     * Validates a client object using the registered validators.
     *
     * @param client the client to be validated
     */
    public void validateClient(Client client) {
        for (Validator<Client> validator : this.validators) {
            validator.validate(client);
        }
    }

    /**
     * Finds a client by its id.
     *
     * @param id the id of the client
     * @return the client with the specified id
     * @throws NoSuchElementException if no client with the specified id is found
     */
    public Client findClientById(int id) {
        Client client = clientDAO.findById(id);
        if (client == null) {
            throw new NoSuchElementException("The client with id = " + id + " wasn't found!");
        }
        return client;
    }

    /**
     * Retrieves all clients from the database.
     *
     * @return a list of all clients
     */
    public List<Client> findAllClients() {
        return clientDAO.findAll();
    }

    /**
     * Inserts a client into the database.
     *
     * @param client the client to be inserted
     */
    public void insertClient(Client client) {
        clientDAO.insert(client);
    }

    /**
     * Deletes a client from the database.
     *
     * @param id the id of the client to be deleted
     */
    public void deleteClient(int id) {
        clientDAO.delete(id);
    }

    /**
     * Updates a client in the database.
     *
     * @param client the client to be updated
     */
    public void updateClient(Client client) {
        clientDAO.update(client);
    }

    /**
     * Generates a JTable representation of a list of clients.
     *
     * @param listOfClients the list of clients to be displayed in the table
     * @return a JTable containing the clients' data
     */
    public JTable generateClientsTable(List<Client> listOfClients) {
        return clientDAO.generateTable(listOfClients);
    }
}
