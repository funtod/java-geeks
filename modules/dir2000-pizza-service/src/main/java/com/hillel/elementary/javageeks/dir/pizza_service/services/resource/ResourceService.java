package com.hillel.elementary.javageeks.dir.pizza_service.services.resource;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.services.discount.DiscountService;

public interface ResourceService {
    DiscountService[] readDiscountTerms();

    Pizza[] readPizzas();
}
