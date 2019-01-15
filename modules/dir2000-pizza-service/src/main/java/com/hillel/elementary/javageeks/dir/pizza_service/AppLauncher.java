package com.hillel.elementary.javageeks.dir.pizza_service;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
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
import com.hillel.elementary.javageeks.dir.pizza_service.services.notifier.NotifierService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.notifier.SimpleNotifierService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.order.OrderService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.order.SimpleOrderService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.PizzaService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.SimplePizzaService;

public final class AppLauncher {
    private AppLauncher() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println("-===Pizza service===-");
        System.out.println();

        CustomerRepository customerRepository = new InMemCustomerRepository();
        CustomerService customerService = new SimpleCustomerService(customerRepository);
        Customer customer = customerService.register(new Customer(null, "Vanya"));

        PizzaRepository pizzaRepository = new InMemPizzaRepository();
        PizzaService pizzaService = new SimplePizzaService(pizzaRepository);

        OrderRepository orderRepository = new InMemOrderRepository();

        NotifierService notifierService = new SimpleNotifierService();
        ChefService chefService = new WaitingThreadChefService(notifierService, orderRepository);
        OrderService orderService = new SimpleOrderService(orderRepository, pizzaService, chefService);

        System.out.println("Available pizzas:");
        System.out.println(pizzaService.getAll());
        System.out.println();

        Long idOne = 1L;
        Long idTwo = 2L;
        Long idThree = 3L;

        Order order = orderService.placeNewOrder(customer, idOne, idTwo, idThree);
        notifierService.notifyCustomer(order);
        chefService.finishWork();
    }
}
