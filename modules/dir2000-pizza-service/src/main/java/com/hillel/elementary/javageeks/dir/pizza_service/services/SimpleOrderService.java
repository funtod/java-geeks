package com.hillel.elementary.javageeks.dir.pizza_service.services;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.OrderRepository;

public class SimpleOrderService implements OrderService {
    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private ChefService chefService;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService, ChefService chefService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.chefService = chefService;
    }

    @Override
    public Order placeNewOrder(Customer customer, Long... ids) {
        return null;
    }
}
