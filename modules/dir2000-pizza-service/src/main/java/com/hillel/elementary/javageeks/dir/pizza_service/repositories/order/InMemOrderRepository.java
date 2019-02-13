package com.hillel.elementary.javageeks.dir.pizza_service.repositories.order;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component("orderRepository")
public class InMemOrderRepository implements OrderRepository {
    private final Map<Long, Order> orders = new HashMap<>();
    private Long counter = 0L;

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

    @Override
    public synchronized Collection<Order> findAllCustomerOrders(Customer customer) {
        return orders.values().stream()
                .filter(o -> customer.equals(o.getCustomer()))
                .collect(Collectors.toList());
    }
}
