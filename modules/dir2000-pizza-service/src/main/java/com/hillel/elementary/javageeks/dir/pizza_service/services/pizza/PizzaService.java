package com.hillel.elementary.javageeks.dir.pizza_service.services.pizza;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;

import java.util.Collection;

public interface PizzaService {
    Pizza getById(Long id);

    Pizza register(Pizza pizza);

    Collection<Pizza> getAll();
}
