package com.hillel.elementary.javageeks.dir.pizza_service.services.discount;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;

import java.math.BigDecimal;
import java.util.Map;

public interface DiscountGroupService {
  void giveDiscount(Map<Pizza, BigDecimal> costs);
}
