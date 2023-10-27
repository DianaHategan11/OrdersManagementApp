package org.example.bll;

import org.example.bll.validators.ProductStockValidator;
import org.example.bll.validators.Validator;
import org.example.dao.ProductDAO;
import org.example.model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductBLL {
    private ProductDAO productDAO;
    private Validator<Product> validator;

    public ProductBLL() {
        this.productDAO = new ProductDAO();
        this.validator = new ProductStockValidator();
    }

    public void validateProduct(Product product) {
        this.validator.validate(product);
    }

    public Product findProductById(int id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            throw new NoSuchElementException("The product with id = " + id + "wasn't found!");
        }
        return product;
    }

    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

    public void insertProduct(Product product) {
        productDAO.insert(product);
    }

    public void deleteProduct(int id) {
        productDAO.delete(id);
    }

    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    public JTable generateProductsTable(List<Product> listOfProducts) {
        return productDAO.generateTable(listOfProducts);
    }
}
