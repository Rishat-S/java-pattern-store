package ru.netology.product;

import ru.netology.delivery.Status;

import java.util.ArrayList;
import java.util.List;

public class Order {
    protected Filter filter;
    protected FilterFlag filterFlag;
    protected String filterValue;
    protected Status status;
    protected List<ProductItem> productItemList;

    public Order() {
        filter = new Filter();
        filterFlag = FilterFlag.CLEAR;
        productItemList = new ArrayList<>();
        status = Status.CREATED;
    }

    public double orderSum() {
        double result = 0;
        for (ProductItem productItem : productItemList) {
            result = result + productItem.getSum();
        }
        return result;
    }

    public void setFilterFlag(FilterFlag filterFlag, String filterValue) {
        this.filterFlag = filterFlag;
        this.filterValue = filterValue;
    }

    public int orderSize() {
        return productItemList.size();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean insertProduct(Product product, int quantity) {
        return productItemList.add(new ProductItem(product, quantity));
    }

    public List<ProductItem> getProductItem() {
        return productItemList;
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

    public void printOrder(List<ProductItem> productItems) {
        System.out.println(" N  Name        Price  Quantity");
        for (ProductItem productItem : productItems) {
            System.out.printf("%2d. %-10s %.2f %9d\n",
                    (getProductItem().indexOf(productItem) + 1),
                    productItem.getProduct().getName(),
                    productItem.getProduct().getPrice(),
                    productItem.getQuantity()
            );
        }
    }

    public Product selectProduct(int index, int quantity) {
        Product product = productItemList.get(index).getProduct();
        changeTheQuantity(index, quantity);
        return product;
    }

    public void changeTheQuantity(int index, int quantity) {
        productItemList.get(index).setQuantity(productItemList.get(index).getQuantity() - quantity);
    }
}
