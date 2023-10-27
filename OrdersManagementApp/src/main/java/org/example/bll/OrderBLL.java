package org.example.bll;

import org.example.bll.validators.OrderQuantityValidator;
import org.example.bll.validators.Validator;
import org.example.dao.BillDAO;
import org.example.dao.ClientDAO;
import org.example.dao.OrderDAO;
import org.example.dao.ProductDAO;
import org.example.model.Bill;
import org.example.model.Client;
import org.example.model.Order;
import org.example.model.Product;

import javax.swing.*;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The OrderBLL class is responsible for handling business logic operations related to orders.
 */
public class OrderBLL {
    private OrderDAO orderDAO;
    private Validator<Order> validator;

    /**
     * Constructs a new OrderBLL object and initializes the orderDAO and the validator.
     */
    public OrderBLL() {
        this.orderDAO = new OrderDAO();
        this.validator = new OrderQuantityValidator();
    }

    /**
     * Validates an order object using the registered validator.
     *
     * @param order the order to be validated
     */
    public void validateOrder(Order order) {
        this.validator.validate(order);
    }

    /**
     * Inserts the specified order into the database and performs associated operations.
     *
     * @param order the order to be inserted
     * @throws OrderException         if there is an error with the order
     * @throws NoSuchElementException if the client or product associated with the order is not found
     */
    public void insertOrder(Order order) throws OrderException, NoSuchElementException {
        double totalPrice = 0;
        ClientDAO clientDAO = new ClientDAO();
        Client client = clientDAO.findById(order.getIdClient());
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findById(order.getIdProduct());
        if (client == null) {
            throw new NoSuchElementException("The client with id = " + order.getIdClient() + " wasn't found!");
        } else if (product == null) {
            throw new NoSuchElementException("The product with id = " + order.getIdProduct() + " wasn't found!");
        } else if (order.getQuantity() > product.getStock()) {
            throw new OrderException("Cannot buy the product with id = " + order.getIdProduct());
        } else {
            product.setStock(product.getStock() - order.getQuantity());
            productDAO.update(product);
            orderDAO.insert(order);
            totalPrice = order.getQuantity() * product.getPrice();
            BillBLL billBLL = new BillBLL();
            Bill bill = new Bill(0, client.getName(), client.getEmailAddress(),
                    product.getName(), order.getQuantity(), totalPrice);
            billBLL.insertBill(bill);
        }
    }

    /**
     * Retrieves all orders from the database.
     *
     * @return a list of all orders
     */
    public List<Order> findAllOrders() {
        return orderDAO.findAll();
    }

    /**
     * Generates a JTable representation of a list of orders.
     *
     * @param listOfOrders the list of orders to be displayed in the table
     * @return a JTable containing the order's data
     */
    public JTable generateOrdersTable(List<Order> listOfOrders) {
        return orderDAO.generateTable(listOfOrders);
    }
}
