package ru.netology.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public void setFilter(Order storeOrder, BufferedReader br) {
        System.out.println("Pull out the filter and its value through a space:\n" +
                "0 - cancel\n" +
                "1 - filter by name\n" +
                "2 - filter by price\n" +
                "3 - filter by manufacturer"
        );

        try {
            String sInput = br.readLine();
            if (sInput.equals("0")) {
                storeOrder.setFilterFlag(FilterFlag.CLEAR, null);
                return;
            }
            String[] strings = sInput.split(" ");
            switch (strings[0]) {
                case "1": {
                    storeOrder.setFilterFlag(FilterFlag.BY_NAME, strings[1]);
                    break;
                }
                case "2": {
                    storeOrder.setFilterFlag(FilterFlag.BY_PRICE, strings[1]);
                    break;
                }
                case "3": {
                    storeOrder.setFilterFlag(FilterFlag.BY_MANUFACTURER, strings[1]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ProductItem> filterByName(List<ProductItem> productItemList, String nameProduct) {
        return productItemList.stream()
                .filter(x -> x.productName().startsWith(nameProduct))
                .collect(Collectors.toList());
    }

    public List<ProductItem> filterByPrice(List<ProductItem> productItemList, int price) {
        return productItemList.stream()
                .filter(x -> x.productPrice() == price)
                .collect(Collectors.toList());
    }

    public List<ProductItem> filterByManufacturer(List<ProductItem> productItemList, String manufacturer) {
        return productItemList.stream()
                .filter(x -> x.productManufacturer().startsWith(manufacturer))
                .collect(Collectors.toList());
    }
}
