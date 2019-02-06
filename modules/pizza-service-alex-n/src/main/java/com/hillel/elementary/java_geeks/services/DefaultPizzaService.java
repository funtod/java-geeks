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
            String msg = "PizzaRepo must not be null";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
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
            String msg = "pizzaId must be grater than 0";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        return pizzaRepo.findById(pizzaId);
    }
}
