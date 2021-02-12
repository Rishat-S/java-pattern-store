package ru.netology.delivery;

import ru.netology.orders.Order;

public class FromItIsDeliveredStatusMover extends OrderMover {
    @Override
    protected void moveToStatus(Order order, Status requestedStatus) {
        super.moveToStatus(order, requestedStatus);
        switch (requestedStatus) {
            case IT_IS_DELIVERED: {
                System.out.printf("Cannot transfer from status %s to status %s\n",
                        order.getStatus(), requestedStatus);
                break;
            }
            case CREATED:
            case PAID:
            case WITHDRAW:
            case ARCHIVE:
            case DELIVERED: {
                order.setStatus(requestedStatus);
            }
        }
    }
}
