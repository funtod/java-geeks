package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.OrderStatus;
import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.repositories.OrderRepo;

public class DefaultOrderService implements OrderService {

    private OrderRepo orderRepo;

    public DefaultOrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepo.saveOrder(order);
    }

    @Override
    public Order saveOrder(Customer customer, Pizza... pizzas) {
        return orderRepo.saveOrder(new Order(customer, pizzas));
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
