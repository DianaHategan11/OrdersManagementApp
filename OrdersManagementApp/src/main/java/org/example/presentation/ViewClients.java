package org.example.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewClients extends JFrame {
    private JFrame frame;
    private JTextField idInsertField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField addressField;
    private JTextField emailField;
    private JTextField telephoneField;
    private JTextField idUpdateField;
    private JTextField idDeleteField;
    private JButton btnView;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public ViewClients() {
        this.setTitle("Clients");
        this.setBounds(400, 0, 620, 680);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        btnView = new JButton("View clients");
        btnView.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnView.setBounds(224, 26, 135, 37);
        this.getContentPane().add(btnView);

        textArea = new JTextArea();
        textArea.setBounds(75, 89, 456, 292);
        this.getContentPane().add(textArea);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(75, 89, 456, 292);
        this.getContentPane().add(scrollPane);

        btnAdd = new JButton("Add client");
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
        nameLabel.setBounds(128, 508, 38, 14);
        this.getContentPane().add(nameLabel);

        nameField = new JTextField();
        nameField.setColumns(10);
        nameField.setBounds(176, 505, 145, 23);
        this.getContentPane().add(nameField);

        JLabel ageLabel = new JLabel("age:");
        ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        ageLabel.setBounds(128, 537, 27, 20);
        this.getContentPane().add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(176, 539, 47, 23);
        this.getContentPane().add(ageField);
        ageField.setColumns(10);

        btnUpdate = new JButton("Update client");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnUpdate.setBounds(253, 415, 112, 37);
        this.getContentPane().add(btnUpdate);

        btnDelete = new JButton("Delete client");
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

        JLabel addressLabel = new JLabel("address:");
        addressLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        addressLabel.setBounds(338, 508, 59, 14);
        this.getContentPane().add(addressLabel);

        addressField = new JTextField();
        addressField.setColumns(10);
        addressField.setBounds(407, 508, 155, 54);
        this.getContentPane().add(addressField);

        JLabel emailAddressLabel = new JLabel("email address:");
        emailAddressLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        emailAddressLabel.setBounds(128, 602, 95, 14);
        this.getContentPane().add(emailAddressLabel);

        emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(224, 598, 155, 25);
        this.getContentPane().add(emailField);

        JLabel phoneLabel = new JLabel("telephone number:");
        phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        phoneLabel.setBounds(128, 568, 119, 14);
        this.getContentPane().add(phoneLabel);

        telephoneField = new JTextField();
        telephoneField.setColumns(10);
        telephoneField.setBounds(246, 564, 133, 23);
        this.getContentPane().add(telephoneField);
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

    public int getAgeField() {
        return Integer.parseInt(ageField.getText());
    }

    public void setAgeField(int ageField) {
        this.ageField.setText(String.valueOf(ageField));
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

    public String getAddressField() {
        return addressField.getText();
    }

    public void setAddressField(String addressField) {
        this.addressField.setText(addressField);
    }

    public String getEmailField() {
        return emailField.getText();
    }

    public void setEmailField(String emailField) {
        this.emailField.setText(emailField);
    }

    public String getTelephoneField() {
        return telephoneField.getText();
    }

    public void setTelephoneField(String telephoneField) {
        this.telephoneField.setText(telephoneField);
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
        ageField.setText(null);
        addressField.setText(null);
        emailField.setText(null);
        telephoneField.setText(null);
        textArea.setText(null);
    }
}
