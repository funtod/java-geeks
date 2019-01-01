package com.hillel.elementary.javageeks.dir.pizza_service.services.chef;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

public interface ChefService {
    void cook(Order order);

    void shutdownAndAwaitTermination();
}
