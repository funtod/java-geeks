package com.hillel.elementary.javageeks.dir.pizza_service.services.pizza;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Timed;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;

import java.util.Collection;

public interface PizzaService {
    @Timed
    Pizza getById(Long id);

    Pizza register(Pizza pizza);

    @Timed
    Collection<Pizza> getAll();
}
