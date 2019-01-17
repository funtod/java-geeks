package com.hillel.elementary.javageeks.dir.pizza_service.repositories.pizza;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.enums.PizzaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemPizzaRepository implements PizzaRepository {
    private Map<Long, Pizza> pizzas = new HashMap<>();
    private Long counter = 0L;

    public InMemPizzaRepository() {
        initialFill();
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

    private void initialFill() {
        File file = new File(getClass().getClassLoader().getResource("pizzas.json").getFile());
        if (!file.exists()) {
            throw new RuntimeException("File pizzas.json has not been found");
        }

        try (FileReader fileReader = new FileReader(file)) {
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(fileReader);
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj = (JSONObject) array.get(i);

                Long id = (Long) obj.get("id");
                String name = (String) obj.get("name");
                PizzaType pizzaType = PizzaType.valueOf((String) obj.get("pizzaType"));
                int millisecondsToCook = ((Long) obj.get("millisecondsToCook")).intValue();
                BigDecimal price = new BigDecimal((Long) obj.get("price"));

                pizzas.put(id, new Pizza(id, name, pizzaType, millisecondsToCook, price));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
