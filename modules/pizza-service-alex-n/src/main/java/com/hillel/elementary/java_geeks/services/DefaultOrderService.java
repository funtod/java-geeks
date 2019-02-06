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
            String msg = "OrderRepo must not be null";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        if (pizzaService == null) {
            String msg = "PizzaService must not be null";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
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
            String msg = "Order must not be null";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        } else if (order.getPizzas().length < 1) {
            String msg = "There must be at least 1 pizza";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        } else if (order.getCustomer() == null) {
            String msg = "Order must have customer";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        return orderRepo.saveOrder(order);
    }

    @Override
    public Order saveOrder(Customer customer, Pizza... pizzas) {
        for (Pizza pizza : pizzas) {
            if (pizza == null) {
                String msg = "Pizza can not be null";
                LOGGER.error(msg);
                throw new IllegalArgumentException(msg);
            }
        }
        if (customer == null) {
            String msg = "Customer must not be null";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        } else if (pizzas.length < 1) {
            String msg = "There must be at least 1 pizza";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        return orderRepo.saveOrder(new Order(customer, pizzas));
    }

    @Override
    public Order saveOrder(Customer customer, Integer... pizzaIds) {
        if (customer == null) {
            String msg = "Customer must not be null";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        } else if (pizzaIds == null || pizzaIds.length == 0) {
            String msg = "Customer must not be null";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
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
            String msg = "Order can not be null";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        Order orderFromMem = orderRepo.getOrderById(order.getId());
        return "Order: " + orderFromMem.getId() + " - status: " + orderFromMem.getStatus();
    }

    @Override
    public String getOrderStatusInfo(long orderId) {
        if (orderId < 0) {
            String msg = "Id must be grater than 0";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        return getOrderStatusInfo(orderRepo.getOrderById(orderId));
    }

    @Timed(isOn = true)
    @Override
    public Order changeStatus(OrderStatus orderStatus, Long orderId) {
        return orderRepo.changeOrderStatus(orderStatus, orderId);
    }
}
