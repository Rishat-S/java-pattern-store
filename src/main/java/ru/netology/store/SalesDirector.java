package ru.netology.store;

import ru.netology.product.Product;

public class SalesDirector {
    public static void fillStore(Order order) {
        order.insertProductToOrder(new Product("Potato", "Russia", 100.20), 20);
        order.insertProductToOrder(new Product("Tomato", "Turkey", 300.15), 40);
        order.insertProductToOrder(new Product("Onion", "Russia", 120.12), 52);
        order.insertProductToOrder(new Product("Carrot", "Russia", 100.65), 10);
        order.insertProductToOrder(new Product("Pepper", "Turkey", 500.89), 25);
    }
}
