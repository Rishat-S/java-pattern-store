package ru.netology.product;

public class Product {
    private final String NAME;
    private final String MANUFACTURER;
    private double price;

    public Product(String name, String manufacturer, double price) {
        this.NAME = name;
        this.MANUFACTURER = manufacturer;
        this.price = price;
    }

    public String getName() {
        return NAME;
    }

    public String getManufacturer() {
        return MANUFACTURER;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
