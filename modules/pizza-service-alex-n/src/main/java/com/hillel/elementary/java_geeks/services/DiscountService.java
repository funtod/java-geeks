package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Pizza;

import java.math.BigDecimal;

public interface DiscountService {

    public BigDecimal countDiscountCoeficient(Pizza[] pizzas);
}
