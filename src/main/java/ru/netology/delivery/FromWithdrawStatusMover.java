package ru.netology.delivery;

import ru.netology.orders.Order;

public class FromWithdrawStatusMover extends OrderMover {
    @Override
    protected void moveToStatus(Order order, Status requestedStatus) {
        super.moveToStatus(order, requestedStatus);
        switch (requestedStatus) {
            case WITHDRAW: {
                System.out.printf("Cannot transfer from status %s to status %s\n",
                        order.getStatus(), requestedStatus);
                break;
            }
            case CREATED:
            case PAID:
            case IT_IS_DELIVERED:
            case ARCHIVE:
            case DELIVERED: {
                order.setStatus(requestedStatus);
            }
        }
    }
}
