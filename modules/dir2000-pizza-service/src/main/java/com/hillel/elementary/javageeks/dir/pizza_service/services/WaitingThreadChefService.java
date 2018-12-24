package com.hillel.elementary.javageeks.dir.pizza_service.services;

import com.hillel.elementary.javageeks.dir.pizza_service.repositories.OrderRepository;

public class WaitingThreadChefService implements ChefService {
    private ChefListener chefListener;
    private OrderRepository orderRepository;

    public WaitingThreadChefService(ChefListener chefListener, OrderRepository orderRepository) {
        this.chefListener = chefListener;
        this.orderRepository = orderRepository;
    }
}
