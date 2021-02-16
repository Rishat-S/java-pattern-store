package ru.netology.store;

import ru.netology.buyer.Cart;
import ru.netology.product.Product;

import java.io.BufferedReader;
import java.io.IOException;

public class Store {
    protected Order storeOrder;

    public Store() {
        storeOrder = new Order();
        SalesDirector.fillStore(storeOrder);
    }

    public Cart orderGeneration(BufferedReader br, Store store) {
        Cart buyerCart = new Cart();
        System.out.println("Welcome to our store!");
        while (true) {
            System.out.println("Please select by number the products you are interested.");
            store.printStoreOrder();
            System.out.println("f - to filter the list of items\n" +
                    "0 - to complete the purchase of items");

            Integer nInput = getInput(br);

            if (nInput == null) {
                break;
            }

            if (nInput == 0) {
                store.setFilter(br);
                continue;
            }

            if (nInput > store.storeOrderSize()) {
                System.out.println("Incorrect entry");
            } else {
                System.out.println("Enter the required quantity");
                Integer inputQuantity = getInput(br);
                if (inputQuantity == null) {
                    System.out.println("Quantity not specified. Adding item cancelled.");
                } else {
                    if (buyerCart.insertProductItemToOrder(store, nInput, inputQuantity)) {
                        System.out.println("Added product in the cart");
                        buyerCart.printBuyerCart();
                    }
                }
            }
        }
        return buyerCart;
    }

    private Integer getInput(BufferedReader br) {
        String input;
        int nInput = 0;
        try {
            input = br.readLine();
            if (input.equals("0")) {
                return null;
            }
            if (input.equals("f")) {
                return 0;
            }
            nInput = Integer.parseInt(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nInput;
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
        Product selected = storeOrder.getProduct(index);
        storeOrder.changeTheQuantity(index, quantity);
        return selected;
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
}