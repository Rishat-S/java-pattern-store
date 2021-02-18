package ru.netology.product;

public class ProductItem {
    private final Product PRODUCT;
    private int quantity;

    public ProductItem(Product product, int quantity) {
        this.PRODUCT = product;
        this.quantity = quantity;
    }

    public double getSum() {
        return quantity * PRODUCT.getPrice();
    }

    public Product getProduct() {
        return PRODUCT;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String productName() {
        return PRODUCT.getName();
    }

    public double productPrice() {
        return PRODUCT.getPrice();
    }

    public String productManufacturer() {
        return PRODUCT.getManufacturer();
    }
}
