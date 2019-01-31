package com.hillel.elementary.javageeks.sasha.pizza_service.repository;


import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Pizza;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemPizzaRepository implements PizzaRepository {

    private Map<Long, Pizza> pizzas = new HashMap<>();
    private Long counter = 0l;

    public InMemPizzaRepository(Map<Long, Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public Pizza findById(Long id){
        return pizzas.get(id);
    }
    @Override
    public  Pizza save(Pizza pizza){
        if(pizza == null) throw new NullPointerException();
        Pizza pizzaToSave;

        if (pizza.getId() == null) {
            pizzaToSave = new Pizza(++counter,pizza.getName(),pizza.getPrice());
        }
        else if(pizzas.get(pizza.getId()) == null){
            throw new IllegalArgumentException("");
        }
        else {
            pizzaToSave = pizza;
        }
        pizzas.put(pizzaToSave.getId(), pizzaToSave);

        return pizzaToSave;
    }
    @Override
    public Collection<Pizza> findAll(){
        return pizzas.values();
    }


}
