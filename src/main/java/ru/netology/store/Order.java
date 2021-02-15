package ru.netology.store;

import ru.netology.delivery.Status;
import ru.netology.product.Product;
import ru.netology.product.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class Order {
    protected Status status;
    protected List<ProductItem> productItemList;

    public Order() {
        this.productItemList = new ArrayList<>();
        status = Status.CREATED;
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

    public void insertProductToOrder(Product product, int quantity) {
        productItemList.add(new ProductItem(product, quantity));
    }

    public List<ProductItem> getProductItemList() {
        return productItemList;
    }

    public void printOrderItems(List<ProductItem> productItemList) {
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
}
