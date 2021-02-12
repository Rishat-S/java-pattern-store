package ru.netology.delivery;

import ru.netology.orders.Order;

public class OrderMover {
    protected void moveToStatus(Order order, Status requestedStatus) {
        System.out.printf("Moving status to %s\n", requestedStatus);
    }
}
