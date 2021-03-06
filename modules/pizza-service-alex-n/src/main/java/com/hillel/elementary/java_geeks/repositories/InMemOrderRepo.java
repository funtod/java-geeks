package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.OrderStatus;
import com.hillel.elementary.java_geeks.domain.Pizza;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;


@Component("orderRepo")
public class InMemOrderRepo implements OrderRepo {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemOrderRepo.class);
    private HashMap<Long, Order> orders = new HashMap<>();
    private Long counter = 0L;

    @Override
    public synchronized Order saveOrder(Order order) {

        Optional<BigDecimal> total = Arrays.stream(order.getPizzas())
                .map(Pizza::getPrice)
                .reduce(BigDecimal::add);

        Order registeredOrder = new Order(counter,
                order.getCustomer(),
                order.getPizzas(),
                total.get(),
                OrderStatus.IN_PROGRESS);
        orders.put(counter, registeredOrder);
        counter++;
        return registeredOrder;
    }

    @Override
    public Order getOrderById(Long id) {
        if (orders.size() < id) {
            String msg = String.format("There is no order with such id: %d", id);
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
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
