package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.domain.PizzaType;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

public class InMemPizzaRepo implements PizzaRepo {

    private HashMap<Integer, Pizza> pizzas = new HashMap<>();
    private int counter = 0;

    public InMemPizzaRepo() {
        save(new Pizza(null, "Carbonara", PizzaType.MEAT, 1500, new BigDecimal(100)));
        save(new Pizza(null, "Pepperoni", PizzaType.MEAT, 2000, new BigDecimal(150)));
        save(new Pizza(null, "Margarita", PizzaType.VEGETARIAN, 1000, new BigDecimal(250)));
        save(new Pizza(null, "Sicilian", PizzaType.SEAFOOD, 1500, new BigDecimal(200)));
    }

    @Override
    public Collection<Pizza> findAll() {
        return pizzas.values();
    }

    @Override
    public Pizza findById(int pizzaId) {
        return pizzas.get(pizzaId);
    }

    @Override
    public void save(Pizza pizza) {
        if (pizza.getId() == null || pizza.getId() < counter) {
            Pizza pizzaWithId = new Pizza(counter,
                    pizza.getName(),
                    pizza.getPizzaType(),
                    pizza.getCookingTime(),
                    pizza.getPrice());
            pizzas.put(counter, pizzaWithId);
            counter++;
        }
    }
}
