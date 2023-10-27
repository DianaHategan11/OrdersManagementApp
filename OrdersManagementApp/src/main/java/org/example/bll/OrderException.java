package org.example.bll;

/**
 * Custom exception class for handling order-related exceptions.
 */
public class OrderException extends Exception {
    /**
     * Constructs a new OrderException object without a specified detail message.
     */
    public OrderException() {
    }

    /**
     * Constructs a new OrderException object with the specified detail message.
     *
     * @param message the detail message
     */
    public OrderException(String message) {
        super(message);
    }
}