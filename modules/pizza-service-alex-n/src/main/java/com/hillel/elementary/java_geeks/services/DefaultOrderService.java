package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.OrderStatus;
import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.repositories.OrderRepo;

public class DefaultOrderService implements OrderService {

    private OrderRepo orderRepo;

    public DefaultOrderService(OrderRepo orderRepo) {
        if (orderRepo == null) {
            throw new IllegalArgumentException("OrderRepo must not be null");
        }
        this.orderRepo = orderRepo;
    }

    @Override
    public Order saveOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order must not be null");
        } else if (order.getPizzas().length < 1) {
            throw new IllegalArgumentException("There must be at least 1 pizza in order");
        } else if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have customer");
        }
        return orderRepo.saveOrder(order);
    }

    @Override
    public Order saveOrder(Customer customer, Pizza... pizzas) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer must not be null");
        } else if (pizzas.length < 1) {
            throw new IllegalArgumentException("There must be at least 1 pizza in order");
        }
        return orderRepo.saveOrder(new Order(customer, pizzas));
    }

    @Override
    public String getOrderStatusInfo(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order can not be null");
        }
        Order orderFromMem = orderRepo.getOrderById(order.getId());
        return "Order: " + orderFromMem.getId() + " - status: " + orderFromMem.getStatus();
    }

    @Override
    public Order changeStatus(OrderStatus orderStatus, Long orderId) {
        return orderRepo.changeOrderStatus(orderStatus, orderId);
    }
}
