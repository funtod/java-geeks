package com.hillel.elementary.java_geeks;

import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.repositories.*;
import com.hillel.elementary.java_geeks.services.*;

import java.util.Collection;

public class Runner {

    public static void main(String[] args) throws InterruptedException {

        Customer customer = new Customer("John Smith");
        CustomerRepo customerRepo = new InMemCustomerRepo();
        CustomerService customerService = new DefaultCustomerService(customerRepo);
        Customer registeredCustomer = customerService.registerCustomer(customer);

        PizzaRepo pizzaRepo = new InMemPizzaRepo();
        PizzaService pizzaService = new DefaultPizzaService(pizzaRepo);
        Collection<Pizza> pizzas = pizzaService.getAllPizzas();
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }

        OrderRepo orderRepo = new InMemOrderRepo();
        OrderService orderService = new DefaultOrderService(orderRepo);
        CookService cookService = new DefaultCookService(orderService);

        Order orderOne = orderService.saveOrder(registeredCustomer,
                pizzaService.getPizzaById(1),
                pizzaService.getPizzaById(2));
        Order orderTwo = orderService.saveOrder(registeredCustomer,
                pizzaService.getPizzaById(0),
                pizzaService.getPizzaById(3));
        Order orderThree = orderService.saveOrder(registeredCustomer,
                pizzaService.getPizzaById(3),
                pizzaService.getPizzaById(1));

        cookService.passOrderToCook(orderOne);
        cookService.passOrderToCook(orderTwo);
        cookService.passOrderToCook(orderThree);

        System.out.println(orderService.getOrderStatusInfo(orderOne));
        System.out.println(orderService.getOrderStatusInfo(orderTwo));
        System.out.println(orderService.getOrderStatusInfo(orderThree));

        Thread.sleep(7000);

        System.out.println(orderService.getOrderStatusInfo(orderOne));
        System.out.println(orderService.getOrderStatusInfo(orderTwo));
        System.out.println(orderService.getOrderStatusInfo(orderThree));
    }
}
