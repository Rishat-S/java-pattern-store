package ru.netology.participants;

import ru.netology.orders.StoreOrder;
import ru.netology.product.Product;

public class SalesDirector {
    public static void fillStore(StoreOrder storeOrder) {
        storeOrder.insertProductToList(new Product("Potato", 100), 20);
        storeOrder.insertProductToList(new Product("Tomato", 300), 40);
        storeOrder.insertProductToList(new Product("Onion", 120), 52);
        storeOrder.insertProductToList(new Product("Carrot", 100), 10);
        storeOrder.insertProductToList(new Product("Pepper", 500), 25);
    }
}
