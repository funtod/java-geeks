package com.hillel.elementary.javageeks.sasha.pizza_service.repository;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Pizza;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

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

    private void initialPizza() {
        File file = new File(getClass().getClassLoader().getResource("pizza.json").getFile());
        if (!file.exists()) {
            throw new RuntimeException("File pizza.json has not been found");
        }
        try(FileReader fileReader = new FileReader(file)) {
            Type listType = new TypeToken<ArrayList<Pizza>>(){}.getType();
            List<Pizza> pizzaList = new Gson().fromJson(fileReader, listType);

            for (Pizza pizza:pizzaList) {
                pizzas.put(pizza.getId(),pizza);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
