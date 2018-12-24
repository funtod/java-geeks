package com.hillel.elementary.javageeks.dir.pizza_service.domain;

public class Order {
    private long id;
    private OrderStatus orderStatus = OrderStatus.NEW;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
