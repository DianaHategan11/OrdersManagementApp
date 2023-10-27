package org.example.model;

/**
 * The Bill class represents a bill with its associated information.
 * It is a record class, which provides an immutable and concise way to define classes for storing data.
 *
 * @param idBill       the id of the bill
 * @param clientName   the name of the client
 * @param emailAddress the email address of the client
 * @param productName  the name of the product
 * @param quantity     the quantity of the product
 * @param totalPrice   the total price of the order
 */
public record Bill(int idBill, String clientName, String emailAddress,
                   String productName, int quantity, double totalPrice) {

    /**
     * Returns a string representation of the Bill object.
     *
     * @return a String representation of the Bill object
     */
    @Override
    public String toString() {
        return "Bill with id = " + idBill + ':' + '\n' +
                "name of client = " + clientName + '\n' +
                "email address = " + emailAddress + '\n' +
                "name of product = " + productName + '\n' +
                "quantity = " + quantity + '\n' +
                "totalPrice = " + totalPrice + '\n';
    }
}