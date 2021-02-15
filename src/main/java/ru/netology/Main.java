package ru.netology;

import ru.netology.buyer.Cart;
import ru.netology.delivery.Supplier;
import ru.netology.store.Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Store store = new Store();
        Cart cart;

        cart = orderGeneration(br, store);
        if (cart.payOrder(br)) {
            Supplier supplier = new Supplier(cart.getCartOrder());
            supplier.orderItIsDelivered();
            supplier.orderDelivered();
        } else {
            cart.withdrawOrder(store);
        }
    }

    private static Cart orderGeneration(BufferedReader br, Store store) {
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
                        buyerCart.getCartOrder().printOrderItems(buyerCart.getCartOrder().getProductItemList());
                    }
                }
            }
        }
        return buyerCart;
    }

    private static Integer getInput(BufferedReader br) {
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
}
