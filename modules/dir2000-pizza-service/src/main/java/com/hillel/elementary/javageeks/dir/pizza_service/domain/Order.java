package com.hillel.elementary.javageeks.dir.pizza_service.domain;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

public class Order {
  private final Customer customer;
  private final Collection<Pizza> pizzas;
  private long id;
  private OrderStatus orderStatus = OrderStatus.NEW;
  private BigDecimal total;

  public Order(Customer argCustomer, Collection<Pizza> argPizzas) {
    customer = argCustomer;
    pizzas = argPizzas;
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

  public long getId() {
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

  public BigDecimal getTotal() {
    return total;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", orderStatus=" + orderStatus +
            '}';
  }
}
