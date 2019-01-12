package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.OrderStatus;
import com.hillel.elementary.java_geeks.repositories.OrderRepo;

public class DefaultOrderService implements OrderService {

    private OrderRepo orderRepo;
    private CookService cookService = new DefaultCookService(this);

    public DefaultOrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

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
