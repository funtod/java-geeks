package com.hillel.elementary.javageeks.dir.pizza_service.services.discount;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Map;

public class DiscountServiceMonth implements DiscountService {
  private final Long pizzaId;
  private final Month month;
  private final BigDecimal percent;

  public DiscountServiceMonth(Long argPizzaId, Month argMonth, BigDecimal argPercent) {
    pizzaId = argPizzaId;
    month = argMonth;
    percent = argPercent;
  }

  @Override
  public void giveDiscount(Map<Pizza, BigDecimal> costs) {
    Month currentMonth = LocalDate.now().getMonth();
    if (!month.equals(currentMonth)) {
      return;
    }
    for (Map.Entry<Pizza, BigDecimal> entry : costs.entrySet()) {
      if (entry.getKey().getId().equals(pizzaId)) {
        BigDecimal value = entry.getValue();
        BigDecimal newValue = value.subtract(value.multiply(percent).divide(ONE_HUNDRED));
        entry.setValue(newValue);
      }
    }
  }
}
