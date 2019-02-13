package com.hillel.elementary.javageeks.dir.pizza_service.repositories.order;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

import java.util.Collection;

public interface OrderRepository {
    Order findById(Long id);

    Order save(Order order);

    Collection<Order> findAllCustomerOrders(Customer customer);
}
