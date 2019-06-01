package com.hillel.elementary.javageeks.sasha.pizza_service.services;


import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Client;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Pizza;

import java.util.Collection;

public interface PizzaService {
    Collection<Pizza> getAll();
    Pizza getById(Long id);
    Order placeOrder(Client client, Collection<Pizza> pizzas);
}
