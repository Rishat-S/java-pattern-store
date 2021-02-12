package ru.netology;

import ru.netology.orders.FilterOrderItems;
import ru.netology.orders.Order;
import ru.netology.store.StoreOrder;
import ru.netology.store.SalesDirector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FilterOrderItems filterOrderItems = new FilterOrderItems();
        Order storeOrder = new StoreOrder();
        SalesDirector.fillStore(storeOrder);

        System.out.println("Welcome to our store!\n" +
                "Please select the products you are interested.\n");

        while (true) {
            storeOrder.printOrderItems(storeOrder.getProductItemList());

            filterOrderItems.ByName(storeOrder.getProductItemList(), "P");
            filterOrderItems.ByManufacturer(storeOrder.getProductItemList(), "T");
            filterOrderItems.ByPrice(storeOrder.getProductItemList(), 100);

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
