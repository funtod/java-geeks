package com.hillel.elementary.javageeks.dir.pizza_service.services.order;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.order.OrderRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.services.chef.ChefService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.discount.DiscountGroupService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.discount.DiscountService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.PizzaService;

import java.math.BigDecimal;
import java.util.*;

public class SimpleOrderService implements OrderService {
    private final OrderRepository orderRepository;
    private final PizzaService pizzaService;
    private final ChefService chefService;
    private final DiscountGroupService discountGroupService;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService,
                              ChefService chefService, DiscountGroupService discountGroupService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.chefService = chefService;
        this.discountGroupService = discountGroupService;
    }

    @Override
    public Order placeNewOrder(Customer customer, Long... idsOfPizzas) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null!");
        }
        if (customer.getId() == null) {
            throw new IllegalArgumentException("Customer is not registered!");
        }
        if (idsOfPizzas.length == 0) {
            throw new IllegalArgumentException("The identifiers of pizzas is absent!");
        }
        List<Pizza> list = new ArrayList<>();
        for (Long id : idsOfPizzas) {
            list.add(pizzaService.getById(id));
        }
        list = Collections.unmodifiableList(list);
        BigDecimal total = calculateTotal(list);
        Order order = new Order(null, customer, list, total);
        order = orderRepository.save(order);
        chefService.cook(order);
        return order;
    }

    private BigDecimal calculateTotal(Collection<Pizza> collection) {
        HashMap<Pizza, BigDecimal> costs = new HashMap<>();
        for (Pizza pizza: collection) {
            costs.put(pizza, pizza.getPrice());
        }

        discountGroupService.giveDiscount(costs);

        BigDecimal total = BigDecimal.ZERO;
        for (BigDecimal value : costs.values()) {
            total = total.add(value);
        }

        return total;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id);
    }
}
