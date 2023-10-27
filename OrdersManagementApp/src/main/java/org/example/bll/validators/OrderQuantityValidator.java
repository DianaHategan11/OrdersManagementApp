package org.example.bll.validators;

import org.example.model.Order;

public class OrderQuantityValidator implements Validator<Order> {
    @Override
    public void validate(Order t) {
        if (t.getQuantity() < 0) {
            throw new IllegalArgumentException("Cannot buy a negative quantity of a product!");
        }
    }
}
