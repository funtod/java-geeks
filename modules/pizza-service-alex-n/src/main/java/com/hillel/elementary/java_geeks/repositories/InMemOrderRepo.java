package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.OrderStatus;
import com.hillel.elementary.java_geeks.domain.Pizza;

import java.math.BigDecimal;
import java.util.HashMap;


@Component("orderRepo")
public class InMemOrderRepo implements OrderRepo {

    private HashMap<Long, Order> orders = new HashMap<>();
    private Long counter = 0L;

    @Override
    public synchronized Order saveOrder(Order order) {
        BigDecimal total = BigDecimal.ZERO;
        for (Pizza pizza : order.getPizzas()) {
            total = total.add(pizza.getPrice());
        }
        Order registeredOrder = new Order(counter,
                order.getCustomer(),
                order.getPizzas(),
                total,
                OrderStatus.IN_PROGRESS);
        orders.put(counter, registeredOrder);
        counter++;
        return registeredOrder;
    }

    @Override
    public Order getOrderById(Long id) {
        if (orders.size() < id) {
            throw new IllegalArgumentException("There is no order with such id: " + id);
        }
        return orders.get(id);
    }

    @Override
    public Order changeOrderStatus(OrderStatus orderStatus, Long orderId) {
        Order order = orders.remove(orderId);
        Order updatedOrder = new Order(order.getId(),
                order.getCustomer(),
                order.getPizzas(),
                order.getTotal(),
                orderStatus);
        orders.put(updatedOrder.getId(), updatedOrder);
        return updatedOrder;
    }
}
