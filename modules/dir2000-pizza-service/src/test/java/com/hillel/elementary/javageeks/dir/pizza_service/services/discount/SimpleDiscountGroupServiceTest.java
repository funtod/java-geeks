//http://technology.finra.org/code/serialize-deserialize-interfaces-in-java.html
//http://www.javenue.info/post/gson-json-api



//package com.hillel.elementary.javageeks.dir.pizza_service.services.discount;
//
//import com.google.gson.*;
//import java.lang.reflect.Type;
//import org.junit.jupiter.api.Test;
//
//import java.io.*;
//import java.math.BigDecimal;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SimpleDiscountGroupServiceTest {
//
//  @Test
//  void giveDiscount() {
//    SimpleDiscountGroupService service = new SimpleDiscountGroupService();
//    File inputFile = new File(getClass().getClassLoader().getResource("discount_terms_gson.json").getFile());
//
//    try (BufferedReader reader =
//                 new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8))) {
//
//
//
//
//      List<DiscountService> discountServices = service.discountServices;
//      GsonBuilder builder = new GsonBuilder();//setPrettyPrinting
//      builder.registerTypeAdapter(DiscountService.class, new InterfaceAdapter());
//      builder.setPrettyPrinting();
//      Gson gson = builder.create();
//      String json = gson.toJson(discountServices);
//      writer.print(json);
//
//    } catch (FileNotFoundException argE) {
//      argE.printStackTrace();
//    }
//  }
//}
//
//class InterfaceAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T>{
//
//  private static final String CLASSNAME = "CLASSNAME";
//  private static final String DATA = "DATA";
//
//  public T deserialize(JsonElement jsonElement, Type type,
//                       JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//
//    JsonObject jsonObject = jsonElement.getAsJsonObject();
//    JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
//    String className = prim.getAsString();
//    Class klass = getObjectClass(className);
//    return jsonDeserializationContext.deserialize(jsonObject.get(DATA), klass);
//  }
//  public JsonElement serialize(T jsonElement, Type type, JsonSerializationContext jsonSerializationContext) {
//    JsonObject jsonObject = new JsonObject();
//    jsonObject.addProperty(CLASSNAME, jsonElement.getClass().getName());
//    jsonObject.add(DATA, jsonSerializationContext.serialize(jsonElement));
//    return jsonObject;
//  }
//  /****** Helper method to get the className of the object to be deserialized *****/
//  public Class getObjectClass(String className) {
//    try {
//      return Class.forName(className);
//    } catch (ClassNotFoundException e) {
//      //e.printStackTrace();
//      throw new JsonParseException(e.getMessage());
//    }
//  }
//}
//
