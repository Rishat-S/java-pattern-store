package ru.netology;

import ru.netology.store.Store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Store store = new Store();

        System.out.println("Welcome to our store!");

        while (true) {
            System.out.println("Please select by number the products you are interested.");
            store.printStoreOrder();
            System.out.println("0 - to complete the purchase of items");

            String input = null;
            int nInput = 0;
            try {
                input = br.readLine();
                if (input.equals("0")) {
                    System.out.println("Exit");
                    break;
                }
                nInput = Integer.parseInt(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (nInput > store.storeOrderSize()) {
                System.out.println("Incorrect entry");
                continue;
            } else {
//                System.out.println("Enter the required quantity");
//                int inputQuantity = getQuantity(br); // Покупатель указывает требуемое количество товара
//                for (int i = 0; i < store.storeOrderSize(); i++) {
//                    if (nInput == i) { // TODO: implement
//                        // Добавить в корзину покупателя продукт и указать количество
//                        // и удалить из магазина количество купленного товара
//                    }
//                }
            }


        }
    }
}
