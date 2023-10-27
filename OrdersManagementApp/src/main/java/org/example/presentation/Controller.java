package org.example.presentation;

import org.example.bll.BillBLL;
import org.example.bll.ClientBLL;
import org.example.bll.OrderBLL;
import org.example.bll.ProductBLL;
import org.example.model.Bill;
import org.example.model.Client;
import org.example.model.Order;
import org.example.model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The Controller class manages the interaction between the views and the business logic.
 * It handles user actions and updates the views accordingly.
 */
public class Controller {
    private PrincipalView principalView;
    private ViewClients viewClients;
    private ViewProducts viewProducts;
    private ViewOrders viewOrders;

    /**
     * Constructs a Controller object with the specified views.
     *
     * @param principalView the principal window
     * @param viewClients   the window for client operations
     * @param viewProducts  the window for product operations
     * @param viewOrders    the window for creating product orders
     */
    public Controller(PrincipalView principalView, ViewClients viewClients, ViewProducts viewProducts, ViewOrders viewOrders) {
        this.principalView = principalView;
        this.viewClients = viewClients;
        this.viewProducts = viewProducts;
        this.viewOrders = viewOrders;
        this.principalView.addClientsListener((event) -> {
            this.viewClients.setVisible(true);
            this.viewProducts.setVisible(false);
            this.viewOrders.setVisible(false);
        });
        this.principalView.addProductsListener((event) -> {
            this.viewClients.setVisible(false);
            this.viewProducts.setVisible(true);
            this.viewOrders.setVisible(false);
        });
        this.principalView.addOrdersListener((event) -> {
            this.viewClients.setVisible(false);
            this.viewProducts.setVisible(false);
            this.viewOrders.setVisible(true);
        });
        this.viewClients.addInsertListener(new InsertClientListener());
        this.viewClients.addDeleteListener(new DeleteClientListener());
        this.viewClients.addUpdateListener(new UpdateClientListener());
        this.viewClients.addViewListener(new ViewClientsListener());
        this.viewProducts.addInsertListener(new InsertProductListener());
        this.viewProducts.addDeleteListener(new DeleteProductListener());
        this.viewProducts.addUpdateListener(new UpdateProductListener());
        this.viewProducts.addViewListener(new ViewProductsListener());
        this.viewOrders.addOrderListener(new InsertOrderListener());
        this.viewOrders.addViewBillsListener(new ViewBillsListener());
    }

    /**
     * ActionListener implementation for the insert client button in the clients view.
     */
    class InsertClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int clientId = viewClients.getIdInsertField();
                String name = viewClients.getNameField();
                int age = viewClients.getAgeField();
                String address = viewClients.getAddressField();
                String email = viewClients.getEmailField();
                String telephone = viewClients.getTelephoneField();
                Client client = new Client(clientId, name, age, address, email, telephone);
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.validateClient(client);
                clientBLL.insertClient(client);
                viewClients.showSuccessfulMessage("The client was successfully added!");
            } catch (Exception exception) {
                viewClients.showMessage(exception.getMessage());
            }
        }
    }

    /**
     * ActionListener implementation for the update client button in the clients view.
     */
    class UpdateClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int clientId = viewClients.getIdUpdateField();
                String name = viewClients.getNameField();
                int age = viewClients.getAgeField();
                String address = viewClients.getAddressField();
                String email = viewClients.getEmailField();
                String telephone = viewClients.getTelephoneField();
                Client client = new Client(clientId, name, age, address, email, telephone);
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.validateClient(client);
                clientBLL.updateClient(client);
                viewClients.showSuccessfulMessage("The client with id = " + clientId + " was successfully updated!");
            } catch (Exception exception) {
                viewClients.showMessage(exception.getMessage());
            }
        }
    }

    /**
     * ActionListener implementation for the delete client button in the clients view.
     */
    class DeleteClientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int clientId = viewClients.getIdDeleteField();
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.findClientById(clientId);
                clientBLL.deleteClient(clientId);
                viewClients.showSuccessfulMessage("The client with id = " + clientId + " was successfully deleted!");
            } catch (Exception exception) {
                viewClients.showMessage(exception.getMessage());
            }
        }
    }

    /**
     * ActionListener implementation for the view clients button in the clients view.
     */
    class ViewClientsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ClientBLL clientBLL = new ClientBLL();
            List<Client> listOfClients = clientBLL.findAllClients();
            JTable table = clientBLL.generateClientsTable(listOfClients);
            viewClients.getScrollPane().setViewportView(table);
        }
    }

    /**
     * ActionListener implementation for the insert product button in the products view.
     */
    class InsertProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int productId = viewProducts.getIdInsertField();
                String name = viewProducts.getNameField();
                int stock = viewProducts.getStockField();
                double price = viewProducts.getPriceField();
                Product product = new Product(productId, name, stock, price);
                ProductBLL productBLL = new ProductBLL();
                productBLL.validateProduct(product);
                productBLL.insertProduct(product);
                viewProducts.showSuccessfulMessage("The product was successfully added!");
            } catch (Exception exception) {
                viewProducts.showMessage(exception.getMessage());
            }
        }
    }

    /**
     * ActionListener implementation for the update product button in the products view.
     */
    class UpdateProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int productId = viewProducts.getIdUpdateField();
                String name = viewProducts.getNameField();
                int stock = viewProducts.getStockField();
                double price = viewProducts.getPriceField();
                Product product = new Product(productId, name, stock, price);
                ProductBLL productBLL = new ProductBLL();
                productBLL.validateProduct(product);
                productBLL.updateProduct(product);
                viewProducts.showSuccessfulMessage("The product with id = " + productId + " was successfully updated!");
            } catch (Exception exception) {
                viewProducts.showMessage(exception.getMessage());
            }
        }
    }

    /**
     * ActionListener implementation for the delete product button in the products view.
     */
    class DeleteProductListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int productId = viewProducts.getIdDeleteField();
                ProductBLL productBLL = new ProductBLL();
                productBLL.findProductById(productId);
                productBLL.deleteProduct(productId);
                viewProducts.showSuccessfulMessage("The client with id = " + productId + " was successfully deleted!");
            } catch (Exception exception) {
                viewProducts.showMessage(exception.getMessage());
            }
        }
    }

    /**
     * ActionListener implementation for the view products button in the products view.
     */
    class ViewProductsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ProductBLL productBLL = new ProductBLL();
            List<Product> listOfProducts = productBLL.findAllProducts();
            JTable table = productBLL.generateProductsTable(listOfProducts);
            viewProducts.getScrollPane().setViewportView(table);
        }
    }

    /**
     * ActionListener implementation for the insert order button in the orders view.
     */
    class InsertOrderListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int clientId = viewOrders.getIdFieldClient();
                int productId = viewOrders.getIdFieldProduct();
                int quantity = viewOrders.getQuantityField();
                Order order = new Order(clientId, productId, quantity);
                OrderBLL orderBLL = new OrderBLL();
                orderBLL.validateOrder(order);
                orderBLL.insertOrder(order);
                viewOrders.showSuccessfulMessage("The order was successfully placed!");
            } catch (Exception exception) {
                viewOrders.showMessage(exception.getMessage());
            }
        }
    }

    /**
     * ActionListener implementation for the view bills button in the orders view.
     */
    class ViewBillsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                FileWriter fileWriter = new FileWriter("Bills.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                BillBLL billBLL = new BillBLL();
                List<Bill> listOfBills = billBLL.findAllBillsDB();
                for (Bill bill : listOfBills) {
                    bufferedWriter.write(bill.toString());
                }
                JTable table = billBLL.generateBillsTable(listOfBills);
                viewOrders.getScrollPane().setViewportView(table);
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
