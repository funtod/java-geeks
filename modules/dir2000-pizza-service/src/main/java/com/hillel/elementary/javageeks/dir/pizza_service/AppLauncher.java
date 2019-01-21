package com.hillel.elementary.javageeks.dir.pizza_service;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.dir.pizza_service.profiling.Profiler;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer.CustomerRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer.InMemCustomerRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.order.InMemOrderRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.order.OrderRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.pizza.InMemPizzaRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.pizza.PizzaRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.services.chef.ChefService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.chef.WaitingThreadChefService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.customer.CustomerService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.customer.SimpleCustomerService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.discount.DiscountService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.discount.DiscountServiceMonth;
import com.hillel.elementary.javageeks.dir.pizza_service.services.discount.DiscountServicePercent;
import com.hillel.elementary.javageeks.dir.pizza_service.services.discount.DiscountServiceSomeForFree;
import com.hillel.elementary.javageeks.dir.pizza_service.services.notifier.NotifierService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.notifier.SimpleNotifierService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.order.OrderService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.order.SimpleOrderService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.PizzaService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.SimplePizzaService;

import java.math.BigDecimal;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public final class AppLauncher {
    private AppLauncher() {
    }

    public static void main(String[] args) {
        System.out.println("-===Pizza service===-");
        System.out.println();

        CustomerRepository customerRepository = new InMemCustomerRepository();
        CustomerService customerService = new SimpleCustomerService(customerRepository);
        Customer customer = customerService.register(new Customer(null, "Vanya"));

        PizzaRepository pizzaRepository = new InMemPizzaRepository();
        PizzaService pizzaService = new SimplePizzaService(pizzaRepository);
        pizzaService = Profiler.wrap(pizzaService);

        OrderRepository orderRepository = new InMemOrderRepository();
        orderRepository = Profiler.wrap(orderRepository);

        final Long idOne = 1L;
        final Long idTwo = 2L;
        final Long idThree = 3L;

        List<DiscountService> currentDiscountServices = new LinkedList<>();

        final int discountPercentTen = 10;
        currentDiscountServices.add(new DiscountServicePercent(BigDecimal.valueOf(discountPercentTen)));
        final int discountPercentFive = 5;
        currentDiscountServices.add(new DiscountServiceMonth(idTwo, Month.JANUARY,
                BigDecimal.valueOf(discountPercentFive)));
        final int numberOfFreePizza = 3;
        currentDiscountServices.add(new DiscountServiceSomeForFree(numberOfFreePizza));

        NotifierService notifierService = new SimpleNotifierService();

        ChefService chefService = new WaitingThreadChefService(notifierService, orderRepository);
        OrderService orderService = new SimpleOrderService(orderRepository, pizzaService,
                chefService, currentDiscountServices);

        System.out.println("Available pizzas:");
        System.out.println(pizzaService.getAll());
        System.out.println();

        Order order = orderService.placeNewOrder(customer, idOne, idTwo, idThree);
        notifierService.notifyCustomer(order);
        chefService.finishWork();
    }
}
