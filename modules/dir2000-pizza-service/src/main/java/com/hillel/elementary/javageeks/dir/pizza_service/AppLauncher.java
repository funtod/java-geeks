package com.hillel.elementary.javageeks.dir.pizza_service;

import com.hillel.elementary.javageeks.dir.pizza_service.context.Context;
import com.hillel.elementary.javageeks.dir.pizza_service.context.JavaConfig;
import com.hillel.elementary.javageeks.dir.pizza_service.context.SimpleImplementationContext;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.dir.pizza_service.services.chef.ChefService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.customer.CustomerService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.notifier.NotifierService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.order.OrderService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.PizzaService;

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

//    GsonBuilder builder = new GsonBuilder();
//    builder.setPrettyPrinting();
//    Gson gson = builder.create();
//
//    System.out.println(gson.toJson(pizzaService.getById(1L)));
//    System.out.println(gson.toJson(pizzaService.getById(2L)));
//    System.out.println(gson.toJson(pizzaService.getById(3L)));
  }
}
