package com.hillel.elementary.javageeks.dir.pizza_service.services;

import com.hillel.elementary.javageeks.dir.pizza_service.repositories.OrderRepository;

public class ConsoleAwareChefListener implements ChefListener {
    private OrderRepository orderRepository;

    public ConsoleAwareChefListener(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
