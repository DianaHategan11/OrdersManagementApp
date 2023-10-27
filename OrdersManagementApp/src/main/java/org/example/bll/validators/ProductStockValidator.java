package org.example.bll.validators;

import org.example.model.Product;

public class ProductStockValidator implements Validator<Product> {

    @Override
    public void validate(Product t) {
        if (t.getStock() < 0) {
            throw new IllegalArgumentException("Cannot insert a negative stock of a product!");
        }
    }
}
