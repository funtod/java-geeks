package com.hillel.elementary.javageeks.dir.pizza_service;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.*;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.*;
import com.hillel.elementary.javageeks.dir.pizza_service.services.*;

public class AppLauncher {
    public static void main(String[] args) throws Exception{
        System.out.println("-===Pizza service===-");
        System.out.println();

        Customer customer = new Customer("Vasya");

        PizzaRepository pizzaRepository = new InMemPizzaRepository();
        PizzaService pizzaService = new SimplePizzaService(pizzaRepository);
        OrderRepository orderRepository = new InMemOrderRepository();
        ChefListener chefListener = new ConsoleAwareChefListener(orderRepository);
        ChefService chefService = new WaitingThreadChefService(chefListener, orderRepository);
        OrderService orderService = new SimpleOrderService(orderRepository, pizzaService, chefService);

        System.out.println("Available pizzas:");
        System.out.println(pizzaService.getAllPizzas());
        System.out.println();

        Order order = orderService.placeNewOrder(customer, 1L, 2L, 3L);

        System.out.println(order);
        Thread.sleep(2000);
        System.out.println(order);
    }
}
