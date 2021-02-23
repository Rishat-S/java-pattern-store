package ru.netology.buyer;

import ru.netology.delivery.Status;
import ru.netology.product.Order;
import ru.netology.product.ProductItem;

import java.io.BufferedReader;
import java.io.IOException;

public class Cart extends Order {

    @Override
    public boolean payOrder(Order order, BufferedReader br) {
        System.out.println("Your cart:");
        order.printOrder(order.getProductItems());
        System.out.printf("For payment: %.2f\n", order.orderSum());
        System.out.println("1 - Confirm\n" +
                "0 - Cancel");
        try {
            String sInput = br.readLine();
            if (sInput.equals("1")) {
                System.out.println("Payment confirmed");
                order.setStatus(Status.PAID);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Payment canceled");
        return false;
    }


    @Override
    public void withdrawOrder(Order order) {
        order.setStatus(Status.WITHDRAW);
        System.out.println("Item returned to store");
    }
}