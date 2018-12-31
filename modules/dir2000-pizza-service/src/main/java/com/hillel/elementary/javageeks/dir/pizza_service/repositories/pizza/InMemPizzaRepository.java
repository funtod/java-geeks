package com.hillel.elementary.javageeks.dir.pizza_service.repositories.pizza;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.enums.PizzaType;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemPizzaRepository implements PizzaRepository {
    Map<Long, Pizza> pizzas = new HashMap<>();
    Long counter = 0L;

    public InMemPizzaRepository() {
        int millisecondssToCook = 250;
        save(new Pizza(null, "Barbeque", PizzaType.CLASSIC, millisecondssToCook, new BigDecimal("153")));
        millisecondssToCook = 340;
        save(new Pizza(null, "Pepperoni spice", PizzaType.EXOTIC, millisecondssToCook, new BigDecimal("151")));
        millisecondssToCook = 410;
        save(new Pizza(null, "Meat supreme", PizzaType.SUPREME, millisecondssToCook, new BigDecimal("152")));
    }

    @Override
    public synchronized Pizza findById(Long id) {
        return pizzas.get(id);
    }

    @Override
    public synchronized Pizza save(Pizza pizza) {
        if (pizza == null) {
            throw new NullPointerException();
        }
        if (pizza.getId() == null) {
            Pizza pizzaToSave = new Pizza(++counter, pizza.getName(), pizza.getPizzaType(), pizza.getMillisecondsToCook(), pizza.getPrice());
            pizzas.put(pizzaToSave.getId(), pizzaToSave);
            return pizzaToSave;
        } else if (pizzas.get(pizza.getId()) == null) {
            throw new IllegalArgumentException();
        }
        return pizza;
    }

    @Override
    public synchronized Collection<Pizza> findAll() {
        return pizzas.values();
    }
}
