package ru.netology.store;

import ru.netology.orders.Order;

public class Store {
    Order storeOrder = new StoreOrder();

    public Store() {
        SalesDirector.fillStore(storeOrder);
    }

    public Order getStoreOrder() {
        return storeOrder;
    }
}
