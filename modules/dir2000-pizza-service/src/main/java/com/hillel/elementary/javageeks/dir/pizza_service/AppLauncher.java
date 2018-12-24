package com.hillel.elementary.javageeks.dir.pizza_service;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.InMemOrderRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.InMemPizzaRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.OrderRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.PizzaRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.services.*;

public class AppLauncher {
    public static void main(String[] args) throws Exception{
        System.out.println("-===Pizza service===-");
        System.out.println();

        Customer customer = new Customer("Vasya");
        CustomerService customerService = new SimpleCustomerService();
        Customer registeredCustomer = customerService.register(customer);

        PizzaRepository pizzaRepository = new InMemPizzaRepository();
        PizzaService pizzaService = new SimplePizzaService(pizzaRepository);
        OrderRepository orderRepository = new InMemOrderRepository();
        ChefListener chefListener = new ConsoleAwareChefListener(orderRepository);
        ChefService chefService = new WaitingThreadChefService(chefListener, orderRepository);
        OrderService orderService = new SimpleOrderService(orderRepository, pizzaService, chefService);

        System.out.println("Available pizzas:");
        System.out.println(pizzaService.findAllPizzas());
        System.out.println();

        Order order = orderService.placeNewOrder(customer, 1L, 2L, 3L);

        System.out.println(order);
        Thread.sleep(2000);
        System.out.println(order);
    }
}
