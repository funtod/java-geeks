package com.hillel.elementary.javageeks.dir.pizza_service.repositories.order;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

import java.util.HashMap;
import java.util.Map;

public class InMemOrderRepository implements OrderRepository {
    Map<Long, Order> orders = new HashMap<>();
    Long counter = 0L;

    @Override
    public synchronized Order findById(Long id) {
        return orders.get(id);
    }

    @Override
    public synchronized Order save(Order order) {
        if (order == null) {
            throw new NullPointerException();
        }
        if (order.getId() == null) {
            Order orderToSave = new Order(++counter, order.getCustomer(), order.getPizzas(), order.getTotal());
            orders.put(orderToSave.getId(), orderToSave);
            return orderToSave;
        } else if (orders.get(order.getId()) == null) {
            throw new IllegalArgumentException();
        }
        return order;
    }
}
