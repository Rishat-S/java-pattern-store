package ru.netology;

import ru.netology.orders.FilterOrderItems;
import ru.netology.store.Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Store store = new Store();

        System.out.println("Welcome to our store!");

        while (true) {
            System.out.println("Please select by number the products you are interested.");
            store.getStoreOrder().printOrderItems(store.getStoreOrder().getProductItemList());
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
