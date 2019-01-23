package com.hillel.elementary.javageeks.dir.pizza_service;

import com.hillel.elementary.javageeks.dir.pizza_service.context.Context;
import com.hillel.elementary.javageeks.dir.pizza_service.context.JavaConfig;
import com.hillel.elementary.javageeks.dir.pizza_service.context.SimpleImplementationContext;
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
import com.hillel.elementary.javageeks.dir.pizza_service.services.discount.*;
import com.hillel.elementary.javageeks.dir.pizza_service.services.notifier.NotifierService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.notifier.SimpleNotifierService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.order.OrderService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.order.SimpleOrderService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.PizzaService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.SimplePizzaService;

public final class AppLauncher {
  private AppLauncher() {
  }

  public static void main(String[] args) {
    System.out.println("-===Pizza service===-");
    System.out.println();

    JavaConfig javaConfig = new JavaConfig();
    Context context = new SimpleImplementationContext(javaConfig);

    PizzaService pizzaService = context.getBean("pizzaService");
    CustomerService customerService = context.getBean("customerService");
    OrderService orderService = context.getBean("orderService");
    ChefService chefService = context.getBean("chefService");
    NotifierService notifierService = context.getBean("notifierService");

    System.out.println("Available pizzas:");
    System.out.println(pizzaService.getAll());
    System.out.println();

    final Long idOne = 1L;
    final Long idTwo = 2L;
    final Long idThree = 3L;
    Customer customer = customerService.register(new Customer(null, "Vanya"));

    Order order = orderService.placeNewOrder(customer, idOne, idTwo, idThree);
    notifierService.notifyCustomer(order);
    chefService.finishWork();
  }
}
