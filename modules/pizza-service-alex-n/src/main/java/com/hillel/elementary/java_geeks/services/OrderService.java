package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.OrderStatus;
import com.hillel.elementary.java_geeks.domain.Pizza;

public interface OrderService {

    Order saveOrder(Order order);

    String getOrderStatusInfo(Order order);

    Order changeStatus(OrderStatus orderStatus, Long orderId);

    Order saveOrder(Customer customer, Pizza... pizzas);
}
