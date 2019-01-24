package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.domain.PizzaType;

import java.math.BigDecimal;

public class InMemPizzaRepo extends AbstractPizzaRepo {

    private static final Pizza PIZZA_CARBONARA =
            new Pizza(null, "Carbonara", PizzaType.MEAT, 1500, new BigDecimal(100));
    private static final Pizza PIZZA_PEPPERONI =
            new Pizza(null, "Pepperoni", PizzaType.MEAT, 2000, new BigDecimal(150));
    private static final Pizza PIZZA_MARGARITA =
            new Pizza(null, "Margarita", PizzaType.VEGETARIAN, 1000, new BigDecimal(250));
    private static final Pizza PIZZA_SICILIAN =
            new Pizza(null, "Sicilian", PizzaType.SEAFOOD, 1500, new BigDecimal(200));

    public InMemPizzaRepo() {
        initialiseData();
    }

    @Override
    public void initialiseData() {
        save(PIZZA_CARBONARA);
        save(PIZZA_PEPPERONI);
        save(PIZZA_MARGARITA);
        save(PIZZA_SICILIAN);
    }
}
