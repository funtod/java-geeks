package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.OrderStatus;

public interface OrderService {

    Order placeOrder(Order order);

    String getOrderStatusInfo(Order order);

    Order changeStatus(OrderStatus orderStatus, Long orderId);
}
