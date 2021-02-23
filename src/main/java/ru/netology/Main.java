package ru.netology;

import ru.netology.delivery.Deliver;
import ru.netology.product.Order;
import ru.netology.store.SalesDirector;
import ru.netology.store.Seller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Order store = new SalesDirector().fillStore();
        Order cart;
        Seller seller = new Seller();

        cart = seller.orderGeneration(br, store);
        if (cart.payOrder(cart, br)) {
            Deliver supplier = new Deliver(cart);
            supplier.orderItIsDelivered();
            supplier.orderDelivered();
        } else {
            cart.withdrawOrder(store);
        }
    }
}
