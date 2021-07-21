package model;

public class Product {

    private String name;
    private double price;
    private int qty;

    public Product(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public String getName() {
        return name;
    }
}
