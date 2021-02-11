package ru.netology.orders;

import ru.netology.product.Product;
import ru.netology.product.ProductItem;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    protected List<ProductItem> productItemList;

    public Order() {
        this.productItemList = new ArrayList<>();
    }

    public void insertProductToList(Product product, int quantity) {
        productItemList.add(new ProductItem(product, quantity));
    }

    public List<ProductItem> getProductItemList() {
        return productItemList;
    }
}
