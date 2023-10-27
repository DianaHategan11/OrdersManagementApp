package org.example.start;

import org.example.presentation.*;

public class Main {
    public static void main(String[] args) {
        PrincipalView principalView = new PrincipalView();
        ViewClients viewClients = new ViewClients();
        ViewProducts viewProducts = new ViewProducts();
        ViewOrders viewOrders = new ViewOrders();
        Controller controller = new Controller(principalView, viewClients, viewProducts, viewOrders);
    }
}