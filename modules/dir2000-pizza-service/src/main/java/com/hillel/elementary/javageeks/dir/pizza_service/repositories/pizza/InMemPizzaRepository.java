package com.hillel.elementary.javageeks.dir.pizza_service.repositories.pizza;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.enums.PizzaType;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

public class InMemPizzaRepository implements PizzaRepository {
  HashMap<Long, Pizza> pizzas = new HashMap<>();

  public InMemPizzaRepository() {
    Long id = 1L;
    int minutesToCook = 15;
    pizzas.put(id, new Pizza(id, "Barbeque", PizzaType.CLASSIC, minutesToCook, new BigDecimal("153")));

    id = 2L;
    minutesToCook = 17;
    pizzas.put(id, new Pizza(id, "Pepperoni spice", PizzaType.EXOTIC, minutesToCook, new BigDecimal("151")));

    id = 3L;
    minutesToCook = 14;
    pizzas.put(id, new Pizza(id, "Meat supreme", PizzaType.SUPREME, minutesToCook, new BigDecimal("151")));
  }

  @Override
  public Pizza findById(Long id) {
    return pizzas.get(id);
  }

  @Override
  public Pizza save(Pizza order) {
    return null;
  }

  @Override
  public Collection<Pizza> findAllPizzas() {
    return null;
  }
}
