package com.hillel.elementary.javageeks.dir.pizza_service.domain;

import java.math.BigDecimal;
import java.util.Collection;

public class Order {
    private long id;
    private Customer customer;
    private Collection<Pizza> pizzas;
    private OrderStatus orderStatus = OrderStatus.NEW;
    private BigDecimal total;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
