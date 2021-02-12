package ru.netology.store;

import ru.netology.orders.Order;
import ru.netology.product.Product;

public class SalesDirector {
    public static void fillStore(Order order) {
        order.insertProductToList(new Product("Potato","Russia", 100), 20);
        order.insertProductToList(new Product("Tomato","Turkey", 300), 40);
        order.insertProductToList(new Product("Onion", "Russia", 120), 52);
        order.insertProductToList(new Product("Carrot","Russia", 100), 10);
        order.insertProductToList(new Product("Pepper","Turkey", 500), 25);
    }
}
