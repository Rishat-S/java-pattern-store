package ru.netology.delivery;

import ru.netology.orders.Order;

public class FromCreatedStatusMover extends OrderMover {
    @Override
    protected void moveToStatus(Order order, Status requestedStatus) {
        super.moveToStatus(order, requestedStatus);
        switch (requestedStatus) {
            case CREATED: {
                System.out.printf("Cannot transfer from status %s to status %s\n",
                        order.getStatus(), requestedStatus);
                break;
            }
            case PAID:
            case IT_IS_DELIVERED:
            case WITHDRAW:
            case ARCHIVE:
            case DELIVERED: {
                order.setStatus(requestedStatus);
            }
        }
    }
}
