package ru.netology.store;

import ru.netology.product.ProductItem;

import java.util.List;

public class Store {
    Order storeOrder = new StoreOrder();

    public Store() {
        SalesDirector.fillStore(storeOrder);
    }

    public Order getStoreOrder() {
        return storeOrder;
    }

    public int storeOrderSize() {
        return storeOrder.getOrderSize();
    }

    public List<ProductItem> storeItems() {
        return storeOrder.productItemList;
    }

    public void printStoreOrder() {
        storeOrder.printOrderItems(storeOrder.getProductItemList());
    }
}
