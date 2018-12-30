package com.hillel.elementary.javageeks.dir.pizza_service.services.pizza;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.pizza.PizzaRepository;

import java.util.Collection;

public class SimplePizzaService implements PizzaService {
    PizzaRepository pizzaRepository;

    public SimplePizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public Pizza getById(Long id) {
        return pizzaRepository.findById(id);
    }

    @Override
    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public Collection<Pizza> getAll() {
        return pizzaRepository.findAll();
    }
}
