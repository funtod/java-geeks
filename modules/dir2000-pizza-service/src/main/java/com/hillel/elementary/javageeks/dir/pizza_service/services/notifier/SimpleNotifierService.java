package com.hillel.elementary.javageeks.dir.pizza_service.services.notifier;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;

@Component("notifierService")
public class SimpleNotifierService implements NotifierService {
    @Override
    public void notifyCustomer(Order order) {
        System.out.println(order);
    }
}
