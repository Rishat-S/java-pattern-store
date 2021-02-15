package ru.netology.product;

public class ProductItem {
    private Product product;
    private int quantity;

    public ProductItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSum() {
        return quantity * product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
