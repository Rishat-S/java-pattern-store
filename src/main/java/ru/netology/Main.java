package ru.netology;

import ru.netology.orders.Order;
import ru.netology.orders.StoreOrder;
import ru.netology.participants.SalesDirector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Order storeOrder = new StoreOrder();
        SalesDirector.fillStore(storeOrder);

        System.out.println("Welcome to our store!\n" +
                "Please select the products you are interested in store.");

        while (true) {
            storeOrder.printOrderItems();
            System.out.println("0 to exit.");

            String input = br.readLine();

            if (input.equals("0")) {
                break;
            }

//            switch (input) {
//                case ""
//            }
        }
    }
}
