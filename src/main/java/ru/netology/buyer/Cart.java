package ru.netology.buyer;

import ru.netology.delivery.Status;
import ru.netology.product.ProductItem;
import ru.netology.product.Order;
import ru.netology.store.Store;

import java.io.BufferedReader;
import java.io.IOException;

public class Cart {
    protected Order cartOrder;

    public Cart() {
        cartOrder = new Order();
    }

    public boolean insertProduct(Store store, int index, int quantity) {
        return cartOrder.insertProduct(store.takeProductFromStore(index - 1, quantity), quantity);
    }

    public Order getCartOrder() {
        return cartOrder;
    }

    public void printBuyerCart() {
        cartOrder.printOrder(cartOrder.getProductItem());
    }

    public boolean payOrder(BufferedReader br) {
        System.out.println("Your cart:");
        cartOrder.printOrder(cartOrder.getProductItem());
        System.out.printf("For payment: %.2f\n", cartOrder.orderSum());
        System.out.println("1 - Confirm\n" +
                "0 - Cancel");
        try {
            String sInput = br.readLine();
            if (sInput.equals("1")) {
                System.out.println("Payment confirmed");
                cartOrder.setStatus(Status.PAID);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Payment canceled");
        return false;
    }

    public void withdrawOrder(Store store) {
        cartOrder.setStatus(Status.WITHDRAW);
        for (ProductItem productItem : cartOrder.getProductItem()) {
           store.getStoreOrder().insertProduct(productItem.getProduct(),productItem.getQuantity());
        }
        System.out.println("Item returned to store");
    }
}