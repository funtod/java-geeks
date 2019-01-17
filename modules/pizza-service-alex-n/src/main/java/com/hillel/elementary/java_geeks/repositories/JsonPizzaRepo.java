package com.hillel.elementary.java_geeks.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hillel.elementary.java_geeks.domain.Pizza;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class JsonPizzaRepo extends InMemPizzaRepo {

    private static final String PATH_TO_JSON = "pizzas.json";

    public JsonPizzaRepo() {
         super.setPizzas(getDataMapFromJson());
    }

    private HashMap<Integer, Pizza> getDataMapFromJson() {
        List<String> fileText = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URI uri = getClass().getClassLoader().getResource(PATH_TO_JSON).toURI();
            Path path = Paths.get(uri);
            fileText = Files.readAllLines(path);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        for (String line : fileText) {
            stringBuilder.append(line);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Integer, Pizza>>() {
        }.getType();
        Map<Integer, Pizza> myMap = gson.fromJson(stringBuilder.toString(), type);
        return (HashMap<Integer, Pizza>) myMap;
    }
}
