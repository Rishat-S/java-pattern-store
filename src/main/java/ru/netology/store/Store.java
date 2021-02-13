package ru.netology.store;

public class Store {
    Order storeOrder = new StoreOrder();

    public Store() {
        SalesDirector.fillStore(storeOrder);
    }

    public Order getStoreOrder() {
        return storeOrder;
    }
}
