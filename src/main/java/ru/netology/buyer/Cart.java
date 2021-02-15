package ru.netology.buyer;

import ru.netology.product.Product;
import ru.netology.store.Order;

public class Cart {
    protected Order cartOrder;

    public Cart() {
        cartOrder = new Order();
    }

    public void insertProductItemToOrder(Product product, int quantity) {
        cartOrder.insertProductToOrder(product, quantity);
    }

    public Order getCartOrder() {
        return cartOrder;
    }

    public boolean payOrder(Cart cart) {
        // TODO:

        return false;
    }

    public void withdrawOrder() {
        // TODO:
    }
}
