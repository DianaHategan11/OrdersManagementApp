package org.example.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewProducts extends JFrame {
    private JFrame frame;
    private JTextField idInsertField;
    private JTextField nameField;
    private JTextField stockField;
    private JTextField priceField;
    private JTextField idUpdateField;
    private JTextField idDeleteField;
    private JButton btnView;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public ViewProducts() {
        this.setTitle("Products");
        this.setBounds(400, 0, 620, 680);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        btnView = new JButton("View products");
        btnView.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnView.setBounds(245, 26, 135, 37);
        this.getContentPane().add(btnView);

        textArea = new JTextArea();
        textArea.setBounds(75, 89, 456, 292);
        this.getContentPane().add(textArea);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(75, 89, 456, 292);
        this.getContentPane().add(scrollPane);

        btnAdd = new JButton("Add product");
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnAdd.setBounds(75, 415, 112, 37);
        this.getContentPane().add(btnAdd);

        JLabel idLabel = new JLabel("id:");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        idLabel.setBounds(75, 471, 21, 14);
        this.getContentPane().add(idLabel);

        idInsertField = new JTextField();
        idInsertField.setBounds(95, 469, 47, 20);
        this.getContentPane().add(idInsertField);
        idInsertField.setColumns(10);

        JLabel nameLabel = new JLabel("name:");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        nameLabel.setBounds(128, 521, 38, 14);
        this.getContentPane().add(nameLabel);

        nameField = new JTextField();
        nameField.setColumns(10);
        nameField.setBounds(176, 517, 119, 25);
        this.getContentPane().add(nameField);

        JLabel priceLabel = new JLabel("price:");
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        priceLabel.setBounds(128, 553, 38, 20);
        this.getContentPane().add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(176, 553, 59, 25);
        this.getContentPane().add(priceField);
        priceField.setColumns(10);

        btnUpdate = new JButton("Update product");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnUpdate.setBounds(253, 415, 112, 37);
        this.getContentPane().add(btnUpdate);

        btnDelete = new JButton("Delete product");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnDelete.setBounds(419, 415, 112, 37);
        this.getContentPane().add(btnDelete);

        JLabel idLabel_1 = new JLabel("id:");
        idLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        idLabel_1.setBounds(253, 472, 21, 14);
        this.getContentPane().add(idLabel_1);

        JLabel idLabel_1_1 = new JLabel("id:");
        idLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        idLabel_1_1.setBounds(419, 472, 21, 14);
        this.getContentPane().add(idLabel_1_1);

        idUpdateField = new JTextField();
        idUpdateField.setColumns(10);
        idUpdateField.setBounds(274, 469, 47, 20);
        this.getContentPane().add(idUpdateField);

        idDeleteField = new JTextField();
        idDeleteField.setColumns(10);
        idDeleteField.setBounds(440, 469, 47, 20);
        this.getContentPane().add(idDeleteField);

        JLabel stockLabel = new JLabel("stock:");
        stockLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        stockLabel.setBounds(128, 589, 59, 14);
        this.getContentPane().add(stockLabel);

        stockField = new JTextField();
        stockField.setColumns(10);
        stockField.setBounds(176, 589, 59, 25);
        this.getContentPane().add(stockField);
    }

    public int getIdInsertField() {
        return Integer.parseInt(idInsertField.getText());
    }

    public void setIdInsertField(int idInsertField) {
        this.idInsertField.setText(String.valueOf(idInsertField));
    }

    public String getNameField() {
        return nameField.getText();
    }

    public void setNameField(String nameField) {
        this.nameField.setText(nameField);
    }

    public int getStockField() {
        return Integer.parseInt(stockField.getText());
    }

    public void setStockField(int stockField) {
        this.stockField.setText(String.valueOf(stockField));
    }

    public int getIdUpdateField() {
        return Integer.parseInt(idUpdateField.getText());
    }

    public void setIdUpdateField(int idUpdateField) {
        this.idUpdateField.setText(String.valueOf(idUpdateField));
    }

    public int getIdDeleteField() {
        return Integer.parseInt(idDeleteField.getText());
    }

    public void setIdDeleteField(int idDeleteField) {
        this.idDeleteField.setText(String.valueOf(idDeleteField));
    }

    public double getPriceField() {
        return Double.parseDouble(priceField.getText());
    }

    public void setPriceField(double priceField) {
        this.priceField.setText(String.valueOf(priceField));
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

    public void addViewListener(ActionListener actionListener) {
        btnView.addActionListener(actionListener);
    }

    public void addInsertListener(ActionListener actionListener) {
        btnAdd.addActionListener(actionListener);
    }

    public void addUpdateListener(ActionListener actionListener) {
        btnUpdate.addActionListener(actionListener);
    }

    public void addDeleteListener(ActionListener actionListener) {
        btnDelete.addActionListener(actionListener);
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
        idInsertField.setText(null);
        idUpdateField.setText(null);
        idDeleteField.setText(null);
        nameField.setText(null);
        stockField.setText(null);
        priceField.setText(null);
        textArea.setText(null);
    }
}
