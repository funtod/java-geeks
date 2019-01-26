package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.configs.anotations.Timed;
import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.repositories.PizzaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Component("pizzaService")
public class DefaultPizzaService implements PizzaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultPizzaService.class);
    private PizzaRepo pizzaRepo;

    public DefaultPizzaService(PizzaRepo pizzaRepo) {
        if (pizzaRepo == null) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("PizzaRepo must not be null"));
        }
        this.pizzaRepo = pizzaRepo;
    }

    @Timed(isOn = true)
    @Override
    public Collection<Pizza> getAllPizzas() {
        return pizzaRepo.findAll();
    }

    @Override
    public Pizza getPizzaById(int pizzaId) {
        if (pizzaId < 0) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("pizzaId must be grater than 0"));
        }
        return pizzaRepo.findById(pizzaId);
    }
}
