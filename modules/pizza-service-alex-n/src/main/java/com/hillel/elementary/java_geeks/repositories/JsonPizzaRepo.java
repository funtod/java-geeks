package com.hillel.elementary.java_geeks.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.domain.Pizza;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Component("pizzaRepo")
public class JsonPizzaRepo extends AbstractPizzaRepo {

    private static final String PATH_TO_JSON = "pizzas.json";

    public JsonPizzaRepo() {
        initialiseData();
    }

    private HashMap<Integer, Pizza> getDataMapFromJson() {
        String json = null;
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(PATH_TO_JSON).toURI());
            json = new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Integer, Pizza>>() {
        }.getType();
        Map<Integer, Pizza> myMap = gson.fromJson(json, type);
        return (HashMap<Integer, Pizza>) myMap;
    }

    @Override
    public void initialiseData() {
        for (Pizza pizza : getDataMapFromJson().values()) {
            save(pizza);
        }
    }
}
