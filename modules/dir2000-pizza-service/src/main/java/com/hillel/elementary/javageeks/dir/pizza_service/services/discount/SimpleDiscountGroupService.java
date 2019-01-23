package com.hillel.elementary.javageeks.dir.pizza_service.services.discount;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.enums.PizzaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.time.Month;

public class SimpleDiscountGroupService implements DiscountGroupService {
  private final List<DiscountService> discountServices = new LinkedList<>();
  ;

  @Override
  public void giveDiscount(Map<Pizza, BigDecimal> costs) {
    File file = new File(getClass().getClassLoader().getResource("discount_terms.json").getFile());
    if (!file.exists()) {
      throw new RuntimeException("File discount_terms.json has not been found");
    }

    try (FileReader fileReader = new FileReader(file)) {
      JSONParser parser = new JSONParser();
      JSONArray array = (JSONArray) parser.parse(fileReader);
      for (Object item : array) {
        JSONObject obj = (JSONObject) item;

        String className = (String) obj.get("className");
        Class cl = DiscountServicePercent.class;
        String packageName = "com.hillel.elementary.javageeks.dir.pizza_service.services.discount.";
        Class<?> clazz = Class.forName(packageName + className);
        Object[] args;
        if (className.equals("DiscountServicePercent")) {
          Long percent = (Long) obj.get("percent");
          args = new Object[]{BigDecimal.valueOf(percent)};
          try {
            discountServices.add((DiscountServicePercent) clazz.getConstructor(BigDecimal.class).
                    newInstance(args));
          } catch (Exception argE) {
            argE.printStackTrace();
          }
        }
        if (className.equals("DiscountServiceMonth")) {
          Long pizzaId = (Long) obj.get("pizzaId");
          String month = (String) obj.get("month");
          Long percent = (Long) obj.get("percent");
          args = new Object[]{pizzaId, Month.valueOf(month), BigDecimal.valueOf(percent)};
          try {
            discountServices.add((DiscountServiceMonth) clazz.getConstructor(Long.class,
                    Month.class, BigDecimal.class).newInstance(args));
          } catch (Exception argE) {
            argE.printStackTrace();
          }
        }
        if (className.equals("DiscountServiceSomeForFree")) {
          Long numberOfSome = (Long) obj.get("numberOfSome");
          int intValueOfSome = numberOfSome.intValue();
          args = new Object[]{intValueOfSome};
          try {
            discountServices.add((DiscountServiceSomeForFree) clazz.getConstructor(int.class).
                    newInstance(args));
          } catch (Exception argE) {
            argE.printStackTrace();
          }
        }

      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
