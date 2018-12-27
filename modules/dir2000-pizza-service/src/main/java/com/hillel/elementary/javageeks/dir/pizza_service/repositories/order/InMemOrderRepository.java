package com.hillel.elementary.javageeks.dir.pizza_service.repositories.order;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

import java.util.HashMap;

public class InMemOrderRepository implements OrderRepository {
  HashMap<Long, Order> orders = new HashMap<>();

  @Override
  public Order findById(Long id) {
    return orders.get(id);
  }

  @Override
  public Order save(Order order) {
    return null;
  }
}
