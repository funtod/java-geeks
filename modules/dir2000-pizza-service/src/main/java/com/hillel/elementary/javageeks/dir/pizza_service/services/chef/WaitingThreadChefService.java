package com.hillel.elementary.javageeks.dir.pizza_service.services.chef;

import com.hillel.elementary.javageeks.dir.pizza_service.repositories.order.OrderRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.services.chef.ChefListener;
import com.hillel.elementary.javageeks.dir.pizza_service.services.chef.ChefService;

public class WaitingThreadChefService implements ChefService {
    private ChefListener chefListener;
    private OrderRepository orderRepository;

    public WaitingThreadChefService(ChefListener chefListener, OrderRepository orderRepository) {
        this.chefListener = chefListener;
        this.orderRepository = orderRepository;
    }
}
