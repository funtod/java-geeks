package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.OrderStatus;

public interface OrderRepo {

    Order saveOrder(Order order);

    Order getOrderById(Long id);

    Order changeOrderStatus(OrderStatus orderStatus, Long orderId);
}
