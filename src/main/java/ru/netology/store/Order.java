package ru.netology.store;

import ru.netology.delivery.Status;
import ru.netology.product.Product;
import ru.netology.product.ProductItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    protected FilterFlag filterFlag;
    protected String filterValue;
    protected Status status;
    protected List<ProductItem> productItemList;

    public Order() {
        this.filterFlag = FilterFlag.CLEAR;
        this.productItemList = new ArrayList<>();
        status = Status.CREATED;
    }

    public double getOrderSum() {
        double result = 0;

        for (ProductItem productItem : productItemList) {
            result = result + productItem.getSum();
        }

        return result;
    }

    public FilterFlag getFilterFlag() {
        return filterFlag;
    }

    public void setFilterFlag(FilterFlag filterFlag, String string) {
        this.filterFlag = filterFlag;
        this.filterValue = string;
    }

    public int getOrderSize() {
        return productItemList.size();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean insertProductToOrder(Product product, int quantity) {
        return productItemList.add(new ProductItem(product, quantity));
    }

    public List<ProductItem> getProductItemList() {
        return productItemList;
    }

    public void printOrderItems(List<ProductItem> productItemList) {
        if (filterFlag.equals(FilterFlag.BY_NAME)) {
            productItemList = filterByName(filterValue);
        } else if (filterFlag.equals(FilterFlag.BY_PRICE)) {
            productItemList = filterByPrice(Integer.parseInt(filterValue));
        } else if (filterFlag.equals(FilterFlag.BY_MANUFACTURER)) {
            productItemList = filterByManufacturer(filterValue);
        }

        System.out.println(" N  Name        Price  Quantity");
        for (int i = 0; i < productItemList.size(); i++) {
            System.out.printf("%2d. %-10s %.2f %9d\n",
                    (i + 1),
                    productItemList.get(i).getProduct().getName(),
                    productItemList.get(i).getProduct().getPrice(),
                    productItemList.get(i).getQuantity()
            );
        }
    }

    public List<ProductItem> filterByName(String nameProduct) {
        return productItemList.stream()
                .filter(x -> x.getProduct().getName().startsWith(nameProduct))
                .collect(Collectors.toList());
    }

    public List<ProductItem> filterByPrice(int price) {
        return productItemList.stream()
                .filter(x -> x.getProduct().getPrice() == price)
                .collect(Collectors.toList());
    }

    public List<ProductItem> filterByManufacturer(String manufacturer) {
        return productItemList.stream()
                .filter(x -> x.getProduct().getManufacturer().startsWith(manufacturer))
                .collect(Collectors.toList());
    }
}
