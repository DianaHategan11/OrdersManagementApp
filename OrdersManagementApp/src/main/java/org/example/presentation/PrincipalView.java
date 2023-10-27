package org.example.presentation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PrincipalView extends JFrame {
    private JFrame frame;
    private JButton btnClients;
    private JButton btnProducts;
    private JButton btnOrders;

    public PrincipalView() {
        try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:\\TP3\\PT2023_30423_Hategan_Diana_Assignment_3\\PT2023_30423_Hategan_Diana_Assignment_3\\store.jpg")))));
        } catch (IOException e) {
        }
        this.setTitle("Orders Management Application");
        this.setBounds(400, 100, 534, 377);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        btnClients = new JButton("CLIENTS");
        btnClients.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnClients.setBounds(203, 160, 101, 31);
        this.getContentPane().add(btnClients);

        btnProducts = new JButton("PRODUCTS");
        btnProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnProducts.setBounds(190, 200, 128, 33);
        this.getContentPane().add(btnProducts);

        btnOrders = new JButton("ORDERS");
        btnOrders.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnOrders.setBounds(203, 120, 101, 31);
        this.getContentPane().add(btnOrders);

        this.setVisible(true);
    }

    public void addClientsListener(ActionListener actionListener) {
        btnClients.addActionListener(actionListener);
    }

    public void addProductsListener(ActionListener actionListener) {
        btnProducts.addActionListener(actionListener);
    }

    public void addOrdersListener(ActionListener actionListener) {
        btnOrders.addActionListener(actionListener);
    }
}
