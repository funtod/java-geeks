package com.hillel.elementary.javageeks.sasha.pizza_service.repository;


import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Order;

public interface OrderRepository {

    Order findById(Long id);
    Order save(Order order);

}
