package com.hillel.elementary.java_geeks;

import com.hillel.elementary.java_geeks.repositories.*;
import com.hillel.elementary.java_geeks.services.*;
import com.hillel.elementary.java_geeks.user_interface.Controller;

public class Runner {

    public static void main(String[] args) {

        CustomerRepo customerRepo = new InMemCustomerRepo();
        CustomerService customerService = new DefaultCustomerService(customerRepo);

        PizzaRepo pizzaRepo = new InMemPizzaRepo();
        PizzaService pizzaService = new DefaultPizzaService(pizzaRepo);

        OrderRepo orderRepo = new InMemOrderRepo();
        OrderService orderService = new DefaultOrderService(orderRepo, pizzaService);
        CookService cookService = new DefaultCookService(orderService);

        Controller controller = new Controller(customerService, orderService, pizzaService, cookService);
        controller.runUserInterface();
    }
}
