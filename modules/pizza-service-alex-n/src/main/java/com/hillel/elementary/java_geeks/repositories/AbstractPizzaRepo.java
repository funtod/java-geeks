package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.exceptions.AppInitialisationException;

import java.util.Collection;
import java.util.HashMap;

public abstract class AbstractPizzaRepo implements PizzaRepo {

    private static HashMap<Integer, Pizza> pizzas = new HashMap<>();
    private static int counter = 0;

    @Override
    public abstract void initialiseData() throws AppInitialisationException;

    @Override
    public Collection<Pizza> findAll() {
        return pizzas.values();
    }

    @Override
    public Pizza findById(int pizzaId) {
        if (pizzaId > pizzas.size() - 1) {
            return null;
        } else {
            return pizzas.get(pizzaId);
        }
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
        } else if (pizza.getId() != null & !pizzas.containsKey(pizza.getId())) {
            pizzas.put(pizza.getId(), pizza);
        }
    }
}
