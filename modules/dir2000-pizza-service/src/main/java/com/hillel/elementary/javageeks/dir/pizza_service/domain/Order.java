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

    public Order(Order anotherOrder) {
        id = anotherOrder.id;
        customer = anotherOrder.customer;
        pizzas = anotherOrder.pizzas;
        total = anotherOrder.total;
        orderStatus = anotherOrder.orderStatus;
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
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", pizzas count =" + pizzas.size() +
                ", orderStatus=" + orderStatus +
                ", total=" + total +
                '}';
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
