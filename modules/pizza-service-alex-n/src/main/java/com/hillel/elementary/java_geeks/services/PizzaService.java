package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Pizza;

import java.util.Collection;

public interface PizzaService {

    Collection<Pizza> getAllPizzas();

    Pizza getPizzaById(int pizzaId);
}
