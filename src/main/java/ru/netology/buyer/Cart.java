package ru.netology.buyer;

import ru.netology.product.Product;

public class Cart {
    protected CartOrder cartOrder;

    public Cart() {
        cartOrder = new CartOrder();
    }

    public void insertProductItemToOrder(Product product, int quantity) {
        cartOrder.insertProductToOrder(product, quantity);
    }

}
