package com.hillel.elementary.javageeks.dir.pizza_service.services.notifier;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Timed;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

public interface NotifierService {
    @Timed
    void notifyCustomer(Order order);
}
