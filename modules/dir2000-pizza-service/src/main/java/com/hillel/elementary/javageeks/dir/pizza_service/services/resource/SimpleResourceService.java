package com.hillel.elementary.javageeks.dir.pizza_service.services.resource;

import com.google.gson.*;
import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.services.discount.DiscountService;
import com.hillel.elementary.javageeks.dir.pizza_service.utility.Logging;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


@Component("resourceService")
public class SimpleResourceService implements ResourceService {
  private final String DISCOUNT_TERMS_FILE_NAME = "discount_terms.json";
  private final String PIZZAS_FILE_NAME = "pizzas.json";

  @Override
  public Pizza[] readPizzas() {
    return readJsonFile(Pizza.class, PIZZAS_FILE_NAME);
  }

  @Override
  public DiscountService[] readDiscountTerms() {
    return readJsonFile(DiscountService.class, DISCOUNT_TERMS_FILE_NAME);
  }

  public <T> T[] readJsonFile(Class<T> klass, String fileName) {
    File inputFile = new File(getClass().getClassLoader().getResource(fileName).getFile());

    try {
      byte[] encoded = Files.readAllBytes(inputFile.toPath());
      String json = new String(encoded, StandardCharsets.UTF_8);

      GsonBuilder builder = new GsonBuilder();
      if (klass.isInterface()) {
        builder.registerTypeAdapter(klass, new InterfaceAdapter());
      }
      Gson gson = builder.create();
      T[] arrayT = (T[]) Array.newInstance(klass, 0);
      T[] array = gson.<T[]>fromJson(json, arrayT.getClass());
      return array;

    } catch (IOException ex) {
      Logging.logStackTrace(ex);
      throw new IllegalStateException(ex.getMessage());
    }
  }

  private static class InterfaceAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {

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
        throw new JsonParseException("Class not found " + e.getMessage());
      }
    }
  }
}


