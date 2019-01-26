package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.configs.anotations.Timed;
import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.OrderStatus;
import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.repositories.OrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("orderService")
public class DefaultOrderService implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultOrderService.class);
    private OrderRepo orderRepo;
    private PizzaService pizzaService;

    public DefaultOrderService(OrderRepo orderRepo, PizzaService pizzaService) {
        if (orderRepo == null) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("OrderRepo must not be null"));
        }
        if (pizzaService == null) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("PizzaService must not be null"));
        }
        this.pizzaService = pizzaService;
        this.orderRepo = orderRepo;
    }

    @Override
    public Order getOrder(long orderId) {
        return orderRepo.getOrderById(orderId);
    }

    @Override
    public Order saveOrder(Order order) {
        if (order == null) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("Order must not be null"));
        } else if (order.getPizzas().length < 1) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("There must be at least 1 pizza"));
        } else if (order.getCustomer() == null) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("Order must have customer"));
        }
        return orderRepo.saveOrder(order);
    }

    @Override
    public Order saveOrder(Customer customer, Pizza... pizzas) {
        for (Pizza pizza : pizzas) {
            if (pizza == null) {
                LOGGER.error("Something is wrong:", new IllegalArgumentException("Pizza can not be null"));
            }
        }
        if (customer == null) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("Customer must not be null"));
        } else if (pizzas.length < 1) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("There must be at least 1 pizza"));
        }
        return orderRepo.saveOrder(new Order(customer, pizzas));
    }

    @Override
    public Order saveOrder(Customer customer, int... pizzaIds) {
        if (customer == null) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("Customer must not be null"));
        } else if (pizzaIds == null || pizzaIds.length == 0) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("there must be at least 1 pizza id"));
        }
        Pizza[] pizzas = new Pizza[pizzaIds.length];
        for (int i = 0; i < pizzaIds.length; i++) {
            pizzas[i] = pizzaService.getPizzaById(pizzaIds[i]);
        }
        return saveOrder(customer, pizzas);
    }

    @Override
    public String getOrderStatusInfo(Order order) {
        if (order == null) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("Order can not be null"));
        }
        Order orderFromMem = orderRepo.getOrderById(order.getId());
        return "Order: " + orderFromMem.getId() + " - status: " + orderFromMem.getStatus();
    }

    @Override
    public String getOrderStatusInfo(long orderId) {
        if (orderId < 0) {
            LOGGER.error("Something is wrong:", new IllegalArgumentException("Id must be grater than 0"));
        }
        return getOrderStatusInfo(orderRepo.getOrderById(orderId));
    }

    @Timed(isOn = true)
    @Override
    public Order changeStatus(OrderStatus orderStatus, Long orderId) {
        return orderRepo.changeOrderStatus(orderStatus, orderId);
    }
}
