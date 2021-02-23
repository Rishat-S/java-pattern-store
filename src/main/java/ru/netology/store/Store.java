package ru.netology.store;

import ru.netology.product.Order;

import java.io.BufferedReader;

public class Store extends Order {

    @Override
    public boolean payOrder(Order order, BufferedReader br) {
        return false;
    }

    @Override
    public void withdrawOrder(Order order) {

    }
}