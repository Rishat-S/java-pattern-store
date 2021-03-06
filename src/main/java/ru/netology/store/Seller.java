package ru.netology.store;

import ru.netology.buyer.Cart;
import ru.netology.filter.Filter;
import ru.netology.product.Order;

import java.io.BufferedReader;
import java.io.IOException;

public class Seller {
    protected Filter filter;

    public Order orderGeneration(BufferedReader br, Order order) {
        Order buyerCart = new Cart();
        System.out.println("Welcome to our store!");
        while (true) {
            System.out.println("Please select by number the products you are interested.");
            order.printFilteredOrder(order.getProductItems());
            System.out.println("f - to filter the list of items\n" +
                    "0 - to complete the purchase of items");

            Integer nInput = getInput(br);

            if (nInput == null) {
                break;
            }

            if (nInput == 0) {
                filter.setFilter(order, br);
                continue;
            }

            if (nInput > order.orderSize()) {
                System.out.println("Incorrect entry");
            } else {
                System.out.println("Enter the required quantity");
                Integer inputQuantity = getInput(br);
                if (inputQuantity == null) {
                    System.out.println("Quantity not specified. Adding item cancelled.");
                } else {
                    if (buyerCart.insertProduct(order.selectProduct(nInput, inputQuantity), inputQuantity)) {
                        System.out.println("Added product in the cart");
                        buyerCart.printFilteredOrder(order.getProductItems());
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
}
