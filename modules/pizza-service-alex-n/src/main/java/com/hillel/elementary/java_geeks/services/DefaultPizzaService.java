package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.repositories.PizzaRepo;

import java.util.Collection;

public class DefaultPizzaService implements PizzaService {

    private PizzaRepo pizzaRepo;

    public DefaultPizzaService(PizzaRepo pizzaRepo) {
        if (pizzaRepo == null) {
            throw new IllegalArgumentException("PizzaRepo must not be null");
        }
        this.pizzaRepo = pizzaRepo;
    }

    @Override
    public Collection<Pizza> getAllPizzas() {
        return pizzaRepo.findAll();
    }

    @Override
    public Pizza getPizzaById(int pizzaId) {
        if (pizzaId < 0) {
            throw new IllegalArgumentException("pizzaId must be grater than 0");
        }
        return pizzaRepo.findById(pizzaId);
    }
}
