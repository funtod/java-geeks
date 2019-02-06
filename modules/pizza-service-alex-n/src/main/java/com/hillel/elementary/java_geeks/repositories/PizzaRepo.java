package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.exceptions.AppInitialisationException;

import java.util.Collection;

public interface PizzaRepo {

    void initialiseData() throws AppInitialisationException;

    Collection<Pizza> findAll();

    Pizza findById(int pizzaId);

    void save(Pizza pizza);
}
