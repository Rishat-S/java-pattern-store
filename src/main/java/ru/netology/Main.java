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

        cart = orderGeneration(br, store); // формирование заказа
        if (cart.payOrder(cart)) { // оплата заказа
            Supplier supplier = new Supplier(cart.getCartOrder());
            supplier.orderItIsDelivered(); // отправка заказа
            supplier.orderDelivered();// доставка заказа
        } else {
            cart.withdrawOrder(); // возврат заказа
        }
    }

    private static Cart orderGeneration(BufferedReader br, Store store) {
        Cart buyerCart = new Cart();
        System.out.println("Welcome to our store!");
        while (true) {
            System.out.println("Please select by number the products you are interested.");
            store.printStoreOrder();
            System.out.println("0 - to complete the purchase of items");

            Integer nInput = getInput(br);
            if (nInput == null) break;

            if (nInput > store.storeOrderSize()) {
                System.out.println("Incorrect entry");
            } else {
                System.out.println("Enter the required quantity");
                Integer inputQuantity = getInput(br);
                if (inputQuantity == null) {
                    System.out.println("Quantity not specified. Adding item cancelled.");
                    continue;
                } else {
                    // TODO: implement
                    // Добавить в корзину покупателя продукт и указать количество
                    // и удалить из магазина количество купленного товара

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
            nInput = Integer.parseInt(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nInput;
    }
// FIXME:       System.out.printf("%2d. %-11s %.2f % .2f % 11.2f\n",
// FIXME:       System.out.printf("%27s: % 10.2f\n", "Result", result);
}
