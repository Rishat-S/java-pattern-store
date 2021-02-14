package ru.netology.store;

public class Store {
    protected Order storeOrder;

    public Store() {
        storeOrder = new StoreOrder();
        SalesDirector.fillStore(storeOrder);
    }

    public int storeOrderSize() {
        return storeOrder.getOrderSize();
    }

    public void printStoreOrder() {
        storeOrder.printOrderItems(storeOrder.getProductItemList());
    }
}
