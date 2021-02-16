package ru.netology.delivery;

import ru.netology.store.Order;

public class Deliver {
    Order deliveryOrder;

    public Deliver(Order deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }

    public void orderItIsDelivered() {
        deliveryOrder.setStatus(Status.IT_IS_DELIVERED);
        System.out.println("Order it is delivered");
    }

    public void orderDelivered() {
        deliveryOrder.setStatus(Status.DELIVERED);
        System.out.println("Order delivered");
    }
}