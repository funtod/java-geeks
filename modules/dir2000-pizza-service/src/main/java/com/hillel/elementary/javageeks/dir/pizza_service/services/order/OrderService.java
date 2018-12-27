package com.hillel.elementary.javageeks.dir.pizza_service.services.order;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.*;

public interface OrderService {
    Order placeNewOrder(Customer customer, Long ... ids);
}
