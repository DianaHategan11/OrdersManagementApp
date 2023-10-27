package org.example.model;

public class Product {
    private int idProduct;
    private String name;
    private int stock;
    private double price;

    public Product() {
    }

    public Product(int idProduct, String name, int stock, double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Product(String name, int stock, double price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", quantity=" + stock +
                ", price=" + price +
                '}';
    }
}
