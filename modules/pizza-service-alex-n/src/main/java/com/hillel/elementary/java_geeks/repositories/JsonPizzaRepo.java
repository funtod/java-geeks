package com.hillel.elementary.java_geeks.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.configs.anotations.PostCreate;
import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.exceptions.AppInitialisationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonPizzaRepo.class);
    private static final String PATH_TO_JSON = "pizzas.json";

    public JsonPizzaRepo() {
    }

    private HashMap<Integer, Pizza> getDataMapFromJson() throws AppInitialisationException {
        String json = null;
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(PATH_TO_JSON).toURI());
            json = new String(Files.readAllBytes(path), Charset.defaultCharset());
        } catch (URISyntaxException | IOException e) {
            String msg = "Can't read pizzas from file: ";
            LOGGER.error(msg, e);
            throw new AppInitialisationException(msg + e);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Map<Integer, Pizza>>() {
        }.getType();
        Map<Integer, Pizza> myMap = gson.fromJson(json, type);
        return (HashMap<Integer, Pizza>) myMap;
    }

    @PostCreate
    @Override
    public void initialiseData() throws AppInitialisationException {
        for (Pizza pizza : getDataMapFromJson().values()) {
            save(pizza);
        }
    }
}
