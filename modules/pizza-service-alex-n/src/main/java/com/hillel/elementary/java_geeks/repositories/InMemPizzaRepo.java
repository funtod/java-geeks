package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.domain.PizzaType;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

public class InMemPizzaRepo implements PizzaRepo {

    private static final Pizza PIZZA_CARBONARA =
            new Pizza(null, "Carbonara", PizzaType.MEAT, 1500, new BigDecimal(100));
    private static final Pizza PIZZA_PEPPERONI =
            new Pizza(null, "Pepperoni", PizzaType.MEAT, 2000, new BigDecimal(150));
    private static final Pizza PIZZA_MARGARITA =
            new Pizza(null, "Margarita", PizzaType.VEGETARIAN, 1000, new BigDecimal(250));
    private static final Pizza PIZZA_SICILIAN =
            new Pizza(null, "Sicilian", PizzaType.SEAFOOD, 1500, new BigDecimal(200));

    private HashMap<Integer, Pizza> pizzas = new HashMap<>();
    private int counter = 0;

    public InMemPizzaRepo() {
        save(PIZZA_CARBONARA);
        save(PIZZA_PEPPERONI);
        save(PIZZA_MARGARITA);
        save(PIZZA_SICILIAN);
    }

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
        }
    }

    public void setPizzas(HashMap<Integer, Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
