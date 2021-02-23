package ru.netology.product;

import ru.netology.delivery.Status;
import ru.netology.filter.Filter;
import ru.netology.filter.FilterFlag;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    protected Filter filter;
    protected FilterFlag filterFlag;
    protected String filterValue;
    protected Status status;
    protected List<ProductItem> productItems;

    public Order() {
        filter = new Filter();
        filterFlag = FilterFlag.CLEAR;
        productItems = new ArrayList<>();
        status = Status.CREATED;
    }

    public abstract boolean insertProduct(Product product, int quantity);

    public int orderSize() {
        return productItems.size();
    }

    public double orderSum() {
        double result = 0;
        for (ProductItem productItem : productItems) {
            result = result + productItem.getSum();
        }
        return result;
    }

    public Product selectProduct(int index, int quantity) {
        Product product = productItems.get(index).getProduct();
        changeTheQuantity(index, quantity);
        return product;
    }

    public void printFilteredOrder(List<ProductItem> productItems) {
        if (filterFlag.equals(FilterFlag.BY_NAME)) {
            productItems = filter.filterByName(productItems, filterValue);
        } else if (filterFlag.equals(FilterFlag.BY_PRICE)) {
            productItems = filter.filterByPrice(productItems, Integer.parseInt(filterValue));
        } else if (filterFlag.equals(FilterFlag.BY_MANUFACTURER)) {
            productItems = filter.filterByManufacturer(productItems, filterValue);
        }
        printOrder(productItems);
    }

    public void changeTheQuantity(int index, int quantity) {
        productItems.get(index).setQuantity(productItems.get(index).getQuantity() - quantity);
    }

    public void setFilterFlag(FilterFlag filterFlag, String filterValue) {
        this.filterFlag = filterFlag;
        this.filterValue = filterValue;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ProductItem> getProductItems() {
        return this.productItems;
    }

    public void printOrder(List<ProductItem> productItems) {
        System.out.println(" N  Name        Price  Quantity");
        for (ProductItem productItem : productItems) {
            System.out.printf("%2d. %-10s %.2f %9d\n",
                    (getProductItems().indexOf(productItem) + 1),
                    productItem.getProduct().getName(),
                    productItem.getProduct().getPrice(),
                    productItem.getQuantity()
            );
        }
    }

    public abstract boolean payOrder(Order order, BufferedReader br);

    public abstract Order getOrder();

    public abstract void withdrawOrder(Order order);
}
