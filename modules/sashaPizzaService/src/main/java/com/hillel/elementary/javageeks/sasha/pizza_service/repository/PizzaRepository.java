package com.hillel.elementary.javageeks.sasha.pizza_service.repository;


import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Pizza;

import java.util.Collection;

public interface PizzaRepository {
    Pizza findById(Long id);
    Pizza save(Pizza pizza);
    Collection<Pizza> findAll();
}
