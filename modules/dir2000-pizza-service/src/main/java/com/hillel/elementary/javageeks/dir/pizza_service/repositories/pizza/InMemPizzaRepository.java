package com.hillel.elementary.javageeks.dir.pizza_service.repositories.pizza;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;
import com.hillel.elementary.javageeks.dir.pizza_service.annotations.PostCreate;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.services.resource.ResourceService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component("pizzaRepository")
public class InMemPizzaRepository implements PizzaRepository {
    private final Map<Long, Pizza> pizzas = new HashMap<>();
    private Long counter = 0L;
    ResourceService resourceService;

    public InMemPizzaRepository(ResourceService argResourceService) {
        resourceService = argResourceService;
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
            Pizza pizzaToSave = new Pizza(++counter, pizza.getName(), pizza.getPizzaType(),
                    pizza.getMillisecondsToCook(), pizza.getPrice());
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

    @PostCreate
    private void initialFill() {
        Pizza[] array = resourceService.readPizzas();
        for (Pizza pizza : array) {
            pizzas.put(pizza.getId(), pizza);
        }

    }
}
