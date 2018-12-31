package com.hillel.elementary.javageeks.dir.pizza_service.domain;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

public class Order {
    private final Long id;
    private final Customer customer;
    private final Collection<Pizza> pizzas;
    private OrderStatus orderStatus = OrderStatus.NEW;
    private final BigDecimal total;

    public Order(Long argId, Customer argCustomer, Collection<Pizza> argPizzas, BigDecimal argTotal) {
        id = argId;
        customer = argCustomer;
        pizzas = argPizzas;
        total = argTotal;
    }

    @Override
    public boolean equals(Object argO) {
        if (this == argO) {
            return true;
        }
        if (argO == null || getClass() != argO.getClass()) {
            return false;
        }
        Order order = (Order) argO;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatus=" + orderStatus +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Collection<Pizza> getPizzas() {
        return pizzas;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
