package com.hillel.elementary.java_geeks;

import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.domain.Order;
import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.services.*;

import java.util.Collection;

public class Runner {

    public static void main(String[] args) throws InterruptedException {

        Customer customer = new Customer("John Smith");
        CustomerService customerService = new DefaultCustomerService();
        Customer registeredCustomer = customerService.registerCustomer(customer);

        PizzaService pizzaService = new DefaultPizzaService();
        Collection<Pizza> pizzas = pizzaService.getAllPizzas();
        for (Pizza pizza: pizzas) {
            System.out.println(pizza);
        }

        Order order = new Order(registeredCustomer, pizzaService.getPizzaById(1), pizzaService.getPizzaById(2));
        Order order1 = new Order(registeredCustomer, pizzaService.getPizzaById(1), pizzaService.getPizzaById(2));
        Order order2 = new Order(registeredCustomer, pizzaService.getPizzaById(1), pizzaService.getPizzaById(2));
        Order order3 = new Order(registeredCustomer, pizzaService.getPizzaById(1), pizzaService.getPizzaById(2));

        OrderService orderService = new DefaultOrderService();
        Order registeredOrder = orderService.placeOrder(order);
        Order registeredOrder1 = orderService.placeOrder(order1);
        Order registeredOrder2 = orderService.placeOrder(order2);
        Order registeredOrder3 = orderService.placeOrder(order3);

        System.out.println(orderService.getOrderStatusInfo(registeredOrder));
        System.out.println(orderService.getOrderStatusInfo(registeredOrder1));
        System.out.println(orderService.getOrderStatusInfo(registeredOrder2));
        System.out.println(orderService.getOrderStatusInfo(registeredOrder3));
        Thread.sleep(5000);
        System.out.println(orderService.getOrderStatusInfo(registeredOrder));
        System.out.println(orderService.getOrderStatusInfo(registeredOrder1));
        System.out.println(orderService.getOrderStatusInfo(registeredOrder2));
        System.out.println(orderService.getOrderStatusInfo(registeredOrder3));
    }
}
