package com.hillel.elementary.java_geeks;

import com.hillel.elementary.java_geeks.repositories.CustomerRepo;
import com.hillel.elementary.java_geeks.repositories.InMemCustomerRepo;
import com.hillel.elementary.java_geeks.repositories.JsonPizzaRepo;
import com.hillel.elementary.java_geeks.repositories.PizzaRepo;
import com.hillel.elementary.java_geeks.repositories.InMemOrderRepo;
import com.hillel.elementary.java_geeks.repositories.OrderRepo;
import com.hillel.elementary.java_geeks.services.CustomerService;
import com.hillel.elementary.java_geeks.services.DefaultCustomerService;
import com.hillel.elementary.java_geeks.services.DefaultPizzaService;
import com.hillel.elementary.java_geeks.services.PizzaService;
import com.hillel.elementary.java_geeks.services.DefaultOrderService;
import com.hillel.elementary.java_geeks.services.OrderService;
import com.hillel.elementary.java_geeks.services.DefaultCookService;
import com.hillel.elementary.java_geeks.services.CookService;
import com.hillel.elementary.java_geeks.user_interface.Controller;

public final class Runner {

    private Runner() {
    }

    public static void main(String[] args) {

        CustomerRepo customerRepo = new InMemCustomerRepo();
        CustomerService customerService = new DefaultCustomerService(customerRepo);

        PizzaRepo pizzaRepo = new JsonPizzaRepo();
        PizzaService pizzaService = new DefaultPizzaService(pizzaRepo);

        OrderRepo orderRepo = new InMemOrderRepo();
        OrderService orderService = new DefaultOrderService(orderRepo, pizzaService);
        CookService cookService = new DefaultCookService(orderService);

        Controller controller = new Controller(customerService, orderService, pizzaService, cookService);
        controller.runUserInterface();
    }
}
