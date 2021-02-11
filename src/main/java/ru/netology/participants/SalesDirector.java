package ru.netology.participants;

import ru.netology.orders.Order;
import ru.netology.product.Product;

public class SalesDirector {
    public static void fillStore(Order order) {
        order.insertProductToList(new Product("Potato", 100), 20);
        order.insertProductToList(new Product("Tomato", 300), 40);
        order.insertProductToList(new Product("Onion", 120), 52);
        order.insertProductToList(new Product("Carrot", 100), 10);
        order.insertProductToList(new Product("Pepper", 500), 25);
    }
}
