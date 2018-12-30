package com.hillel.elementary.javageeks.dir.pizza_service.repositories.pizza;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;

import java.util.Collection;

public interface PizzaRepository {
    Pizza findById(Long id);

    Pizza save(Pizza pizza);

    Collection<Pizza> findAll();
}
