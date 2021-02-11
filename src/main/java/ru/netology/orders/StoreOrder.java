package ru.netology.orders;

public class StoreOrder extends Order {

    @Override
    public void printOrderItems() {
        System.out.println("N Name Price Quantity");
        for (int i = 0; i < productItemList.size(); i++) {
            System.out.println(i + 1 + " "
                    + productItemList.get(i).getProduct().getName() + " "
                    + productItemList.get(i).getProduct().getPrice() + " "
                    + productItemList.get(i).getQuantity() + " "
            );
        }
        System.out.println();
    }
}
