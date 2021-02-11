package ru.netology.orders;

import ru.netology.product.Product;
import ru.netology.product.ProductItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Order {
    protected List<ProductItem> productItemList;
    protected List<ProductItem> filteredItemList;

    public Order() {
        this.productItemList = new ArrayList<>();
    }

    public void insertProductToList(Product product, int quantity) {
        productItemList.add(new ProductItem(product, quantity));
    }

    public List<ProductItem> getProductItemList() {
        return productItemList;
    }

    public void filterOrderItemsByName(String s) {
        filteredItemList = productItemList.stream()
                .filter(x -> x.getProduct().getName().startsWith(s))
                .collect(Collectors.toList());
        System.out.println("Filtered out by name: \"" + s + "\"");
        printOrderItems(filteredItemList);
    }

    public void filterOrderItemsByPrice(int p) {
        filteredItemList = productItemList.stream()
                .filter(x -> x.getProduct().getPrice() == p)
                .collect(Collectors.toList());
        System.out.println("Filtered out by price: \"" + p + "\"");
        printOrderItems(filteredItemList);
    }

    public void filterOrderItemsByManufacturer(String s) {
        filteredItemList = productItemList.stream()
                .filter(x -> x.getProduct().getManufacturer().startsWith(s))
                .collect(Collectors.toList());
        System.out.println("Filtered out by manufacturer: \"" + s + "\"");
        printOrderItems(filteredItemList);
    }

    public abstract void printOrderItems();

    public void printOrderItems(List<ProductItem> productItemList){
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
