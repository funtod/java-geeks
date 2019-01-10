package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.repositories.InMemPizzaRepo;
import com.hillel.elementary.java_geeks.repositories.PizzaRepo;

import java.util.Collection;

public class DefaultPizzaService implements PizzaService {

    private PizzaRepo pizzaRepo;

    public DefaultPizzaService() {
        pizzaRepo = new InMemPizzaRepo();
    }

    @Override
    public Collection<Pizza> getAllPizzas() {
        return pizzaRepo.findAll();
    }

    @Override
    public Pizza getPizzaById(int pizzaId) {
        return pizzaRepo.findById(pizzaId);
    }
}
