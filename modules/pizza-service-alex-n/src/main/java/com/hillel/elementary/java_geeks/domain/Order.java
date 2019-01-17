package com.hillel.elementary.java_geeks.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {

    private Long id;
    private Customer customer;
    private Pizza[] pizzas;
    private BigDecimal total;
    private OrderStatus status;

    public Order(Customer customer, Pizza... pizzas) {
        this.customer = customer;
        this.pizzas = pizzas;
    }

    public Order(Long id, Customer customer, Pizza[] pizzas, BigDecimal total, OrderStatus status) {
        this.id = id;
        this.customer = customer;
        this.pizzas = pizzas;
        this.total = total;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Pizza[] getPizzas() {
        return pizzas;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Order №" + id +
                ", customer: " + customer.getName() +
                ", total = " + total +
                ", status: " + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
