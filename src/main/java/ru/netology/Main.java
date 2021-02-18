package ru.netology;

import ru.netology.buyer.Cart;
import ru.netology.delivery.Deliver;
import ru.netology.store.Store;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Store store = new Store();
        Cart cart;

        cart = store.orderGeneration(br, store);
        if (cart.payOrder(br)) {
            Deliver supplier = new Deliver(cart.getCartOrder());
            supplier.orderItIsDelivered();
            supplier.orderDelivered();
        } else {
            cart.withdrawOrder(store);
        }
    }
}
