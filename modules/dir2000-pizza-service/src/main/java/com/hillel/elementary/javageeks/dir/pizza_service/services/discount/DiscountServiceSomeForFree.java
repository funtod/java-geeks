package com.hillel.elementary.javageeks.dir.pizza_service.services.discount;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;

import java.math.BigDecimal;
import java.util.Map;

public class DiscountServiceSomeForFree implements DiscountService {
  private final int numberOfSome;

  public DiscountServiceSomeForFree(int argNumberOfSome) {
    numberOfSome = argNumberOfSome;
  }

  @Override
  public void giveDiscount(Map<Pizza, BigDecimal> costs) {
    int counter = 0;
    for (Map.Entry<Pizza, BigDecimal> entry : costs.entrySet()) {
        if (++counter % numberOfSome == 0) {
        entry.setValue(BigDecimal.ZERO);
      }
    }
  }
}
