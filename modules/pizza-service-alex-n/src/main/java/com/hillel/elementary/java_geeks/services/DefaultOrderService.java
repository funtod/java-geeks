package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.OrderStatus;
import com.hillel.elementary.java_geeks.repositories.InMemOrderRepo;
import com.hillel.elementary.java_geeks.repositories.OrderRepo;

public class DefaultOrderService implements OrderService {

    private OrderRepo orderRepo = new InMemOrderRepo();
    private CookService cookService = new DefaultCookService(this);

    @Override
    public Order placeOrder(Order order) {
        Order placedOrder = orderRepo.saveOrder(order);
        cookService.passOrderToCook(placedOrder);
        return placedOrder;
    }

    @Override
    public String getOrderStatusInfo(Order order) {
        Order orderFromMem = orderRepo.getOrderById(order.getId());
        return "Order: " + orderFromMem.getId() + " - status: " + orderFromMem.getStatus();
    }

    @Override
    public Order changeStatus(OrderStatus orderStatus, Long orderId) {
        return orderRepo.changeOrderStatus(orderStatus, orderId);
    }
}
