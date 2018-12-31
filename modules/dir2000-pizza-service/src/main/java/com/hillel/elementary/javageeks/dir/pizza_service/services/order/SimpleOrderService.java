package com.hillel.elementary.javageeks.dir.pizza_service.services.order;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.order.OrderRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.services.chef.ChefService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.PizzaService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SimpleOrderService implements OrderService {
    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private ChefService chefService;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService, ChefService chefService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.chefService = chefService;
    }

    @Override
    public Order placeNewOrder(Customer customer, Long... idsOfPizzas) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null!");
        }
        ;
        if (idsOfPizzas.length == 0) {
            throw new IllegalArgumentException("The identifiers of pizzas is absent!");
        }
        List<Pizza> list = new ArrayList<>();
        for (Long id : idsOfPizzas) {
            list.add(pizzaService.getById(id));
        }
        BigDecimal total = calculateTotal(list);
        Order order = new Order(null, customer, list, total);
        orderRepository.save(order);
        return order;
    }

    private BigDecimal calculateTotal(Collection<Pizza> collection) {
        BigDecimal total = BigDecimal.ZERO;
        for (Pizza pizza : collection) {
            total = total.add(pizza.getPrice());
        }
        return total;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id);
    }
}
