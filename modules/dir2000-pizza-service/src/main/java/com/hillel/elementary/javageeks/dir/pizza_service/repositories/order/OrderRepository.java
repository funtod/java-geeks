package com.hillel.elementary.javageeks.dir.pizza_service.repositories.order;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Timed;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

public interface OrderRepository {
    Order findById(Long id);

    Order save(Order order);
}
