package ru.netology.store;

import ru.netology.product.Order;
import ru.netology.product.Product;

import java.io.BufferedReader;

public class Store extends Order {

    @Override
    public boolean insertProduct(Product product, int quantity) {
        return false;
    }

    @Override
    public boolean payOrder(Order order, BufferedReader br) {
        return false;
    }

    @Override
    public Order getOrder() {
        return null;
    }

    @Override
    public void withdrawOrder(Order order) {

    }
}