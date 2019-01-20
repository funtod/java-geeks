package com.hillel.elementary.javageeks.dir.pizza_service.repositories.order;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Timed;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

public interface OrderRepository {
    @Timed
    Order findById(Long id);

    @Timed
    Order save(Order order);
}
