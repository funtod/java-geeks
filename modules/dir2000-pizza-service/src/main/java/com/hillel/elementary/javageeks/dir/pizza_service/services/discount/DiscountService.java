package com.hillel.elementary.javageeks.dir.pizza_service.services.discount;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;

import java.math.BigDecimal;
import java.util.Map;

public interface DiscountService {
  BigDecimal ONE_HUNDRED = new BigDecimal("100");

  void giveDiscount(Map<Pizza, BigDecimal> costs);
}
