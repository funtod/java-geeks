package com.hillel.elementary.javageeks.dir.pizza_service.services.discount;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;

import java.math.BigDecimal;
import java.util.Map;

public class DiscountServicePercent implements DiscountService {
  private final BigDecimal percent;

  public DiscountServicePercent(BigDecimal argPercent) {
    percent = argPercent;
  }

  @Override
  public void giveDiscount(Map<Pizza, BigDecimal> costs) {
    costs.replaceAll((k, v) -> v.subtract(v.multiply(percent).divide(ONE_HUNDRED, SUM_PRECISION)));
  }
}
