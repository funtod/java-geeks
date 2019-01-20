package com.hillel.elementary.javageeks.dir.pizza_service.services.notifier;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

public interface NotifierService {
    void notifyCustomer(Order order);
}
