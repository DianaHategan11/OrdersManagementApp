package org.example.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewOrders extends JFrame {
    private JFrame frame;
    private JTextField idFieldClient;
    private JTextField idFieldProduct;
    private JTextField quantityField;
    private JButton btnOrder;
    private JButton btnViewBills;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public ViewOrders() {
        this.setTitle("Orders");
        this.setBounds(400, 100, 750, 550);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblClient = new JLabel("Select client given by id:");
        lblClient.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblClient.setBounds(51, 105, 145, 21);
        this.getContentPane().add(lblClient);

        JLabel lblProduct = new JLabel("Select product given by id:");
        lblProduct.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblProduct.setBounds(51, 137, 163, 21);
        this.getContentPane().add(lblProduct);

        JLabel lblQuantity = new JLabel("Insert quantity:");
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblQuantity.setBounds(51, 169, 102, 21);
        this.getContentPane().add(lblQuantity);

        idFieldClient = new JTextField();
        idFieldClient.setBounds(216, 106, 48, 21);
        this.getContentPane().add(idFieldClient);
        idFieldClient.setColumns(10);

        idFieldProduct = new JTextField();
        idFieldProduct.setColumns(10);
        idFieldProduct.setBounds(216, 138, 48, 21);
        this.getContentPane().add(idFieldProduct);

        quantityField = new JTextField();
        quantityField.setColumns(10);
        quantityField.setBounds(150, 170, 64, 21);
        this.getContentPane().add(quantityField);

        JLabel lblOrder = new JLabel("Place an order");
        lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
        lblOrder.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblOrder.setBounds(97, 39, 126, 21);
        this.getContentPane().add(lblOrder);

        btnOrder = new JButton("PLACE ORDER");
        btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnOrder.setBounds(86, 226, 128, 33);
        this.getContentPane().add(btnOrder);

        btnViewBills = new JButton("VIEW BILLS");
        btnViewBills.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnViewBills.setBounds(442, 60, 128, 33);
        this.getContentPane().add(btnViewBills);

        textArea = new JTextArea();
        textArea.setBounds(289, 104, 425, 398);
        this.getContentPane().add(textArea);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(289, 104, 425, 398);
        this.getContentPane().add(scrollPane);
    }

    public int getIdFieldClient() {
        return Integer.parseInt(idFieldClient.getText());
    }

    public void setIdFieldClient(int idFieldClient) {
        this.idFieldClient.setText(String.valueOf(idFieldClient));
    }

    public int getIdFieldProduct() {
        return Integer.parseInt(idFieldProduct.getText());
    }

    public void setIdFieldProduct(int idFieldProduct) {
        this.idFieldProduct.setText(String.valueOf(idFieldProduct));
    }

    public int getQuantityField() {
        return Integer.parseInt(quantityField.getText());
    }

    public void setQuantityField(int quantityField) {
        this.quantityField.setText(String.valueOf(quantityField));
    }

    public String getTextArea() {
        return textArea.getText();
    }

    public void setTextArea(String textArea) {
        this.textArea.setText(textArea);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public void addOrderListener(ActionListener actionListener) {
        btnOrder.addActionListener(actionListener);
    }

    public void addViewBillsListener(ActionListener actionListener) {
        btnViewBills.addActionListener(actionListener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Warning!", JOptionPane.WARNING_MESSAGE);
        refresh();
    }

    public void showSuccessfulMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "", JOptionPane.INFORMATION_MESSAGE);
        refresh();
    }

    public void refresh() {
        idFieldClient.setText(null);
        idFieldProduct.setText(null);
        quantityField.setText(null);
    }
}
