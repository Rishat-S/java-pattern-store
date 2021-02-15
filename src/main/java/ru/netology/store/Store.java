package ru.netology.store;

import ru.netology.product.Product;

import java.io.BufferedReader;
import java.io.IOException;

public class Store {
    protected Order storeOrder;

    public Store() {
        storeOrder = new Order();
        SalesDirector.fillStore(storeOrder);
    }

    public int storeOrderSize() {
        return storeOrder.getOrderSize();
    }

    public void printStoreOrder() {
        storeOrder.printOrderItems(storeOrder.getProductItemList());
    }

    public Order getStoreOrder() {
        return storeOrder;
    }

    public void setFilter(BufferedReader br) {
        System.out.println("Pull out the filter and its value through a space:\n" +
                "0 - cancel\n" +
                "1 - filter by name\n" +
                "2 - filter by price\n" +
                "3 - filter by manufacturer"
        );

        try {
            String sInput = br.readLine();
            if (sInput.equals("0")) {
                storeOrder.setFilterFlag(FilterFlag.CLEAR, null);
                return;
            }
            String[] strings = sInput.split(" ");
            switch (strings[0]) {
                case "1": {
                    storeOrder.setFilterFlag(FilterFlag.BY_NAME, strings[1]);
                    break;
                }
                case "2": {
                    storeOrder.setFilterFlag(FilterFlag.BY_PRICE, strings[1]);
                    break;
                }
                case "3": {
                    storeOrder.setFilterFlag(FilterFlag.BY_MANUFACTURER, strings[1]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product selectFromStore(int index, int quantity) {
        Product selected = storeOrder.getProductItemList().get(index).getProduct();
        storeOrder.getProductItemList().get(index).setQuantity(storeOrder.getProductItemList().get(index).getQuantity() - quantity);
        return selected;
    }
}
