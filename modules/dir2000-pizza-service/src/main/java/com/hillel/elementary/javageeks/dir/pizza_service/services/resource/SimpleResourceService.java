package com.hillel.elementary.javageeks.dir.pizza_service.services.resource;

import com.google.gson.*;
import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;
import com.hillel.elementary.javageeks.dir.pizza_service.services.discount.DiscountService;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


@Component("resourceService")
public class SimpleResourceService implements ResourceService {
    private final String DISCOUNT_TERMS_FILE_NAME = "discount_terms.json";

    @Override
    public DiscountService[] readDiscountTerms() {
        File inputFile = new File(getClass().getClassLoader().getResource(DISCOUNT_TERMS_FILE_NAME).getFile());

        try {
            byte[] encoded = Files.readAllBytes(inputFile.toPath());
            String json = new String(encoded, StandardCharsets.UTF_8);

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(DiscountService.class, new InterfaceAdapter());
            Gson gson = builder.create();

            DiscountService[] array = gson.fromJson(json, DiscountService[].class);
            return array;

        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e.getMessage());
        }
    }
}

class InterfaceAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String DATA = "DATA";

    public T deserialize(JsonElement jsonElement, Type type,
                         JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = prim.getAsString();
        Class klass = getObjectClass(className);
        return jsonDeserializationContext.deserialize(jsonObject.get(DATA), klass);
    }

    public JsonElement serialize(T jsonElement, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CLASSNAME, jsonElement.getClass().getName());
        jsonObject.add(DATA, jsonSerializationContext.serialize(jsonElement));
        return jsonObject;
    }

    /****** Helper method to get the className of the object to be deserialized *****/
    public Class getObjectClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
            throw new JsonParseException("Class not found " + e.getMessage());
        }
    }
}
