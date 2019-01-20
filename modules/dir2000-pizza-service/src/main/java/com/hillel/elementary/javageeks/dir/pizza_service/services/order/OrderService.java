package com.hillel.elementary.javageeks.dir.pizza_service.services.order;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

public interface OrderService {
    int SUM_PRECISION = 2;

    Order placeNewOrder(Customer customer, Long... ids);

    Order findById(Long id);
}
