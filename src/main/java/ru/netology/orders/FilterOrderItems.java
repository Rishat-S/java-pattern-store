package ru.netology.orders;

import ru.netology.product.ProductItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterOrderItems {
    List<ProductItem> filteredItemList;

    public FilterOrderItems() {
        this.filteredItemList = new ArrayList<>();
    }

    public void ByName(List<ProductItem> productItemList, String s) {
        filteredItemList = productItemList.stream()
                .filter(x -> x.getProduct().getName().startsWith(s))
                .collect(Collectors.toList());
        System.out.println("Filtered out by name: \"" + s + "\"");
    }

    public void ByPrice(List<ProductItem> productItemList, int p) {
        filteredItemList = productItemList.stream()
                .filter(x -> x.getProduct().getPrice() == p)
                .collect(Collectors.toList());
        System.out.println("Filtered out by price: \"" + p + "\"");
    }

    public void ByManufacturer(List<ProductItem> productItemList, String s) {
        filteredItemList = productItemList.stream()
                .filter(x -> x.getProduct().getManufacturer().startsWith(s))
                .collect(Collectors.toList());
        System.out.println("Filtered out by manufacturer: \"" + s + "\"");
    }

    public List<ProductItem> getFilteredItemList() {
        return filteredItemList;
    }
}
