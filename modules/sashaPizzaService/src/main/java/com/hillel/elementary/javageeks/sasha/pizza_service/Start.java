package com.hillel.elementary.javageeks.sasha.pizza_service;



import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Client;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Status;
import com.hillel.elementary.javageeks.sasha.pizza_service.repository.InMemPizzaRepository;
import com.hillel.elementary.javageeks.sasha.pizza_service.repository.PizzaRepository;

import java.math.BigDecimal;
import java.util.*;

public class Start {

    private static PizzaRepository pizzaRepo;

    public  static void initPizzaRepo(){
        Map<Long, Pizza> pizzas = new HashMap<>();

        pizzas.put(0l, new Pizza(0l, "sample0", BigDecimal.valueOf(0l)));
        pizzas.put(1l, new Pizza(1l, "sample1", BigDecimal.valueOf(10l)));
        pizzas.put(2l, new Pizza(2l, "sample2", BigDecimal.valueOf(20l)));
        pizzas.put(3l, new Pizza(3l, "sample3", BigDecimal.valueOf(30l)));
        pizzas.put(4l, new Pizza(4l, "sample4", BigDecimal.valueOf(40l)));

        pizzaRepo = new InMemPizzaRepository(pizzas);
    }

    public static void main(String[] args) {
        System.out.println("pizza-service");
        System.out.println();

        initPizzaRepo();

        Client client = new Client("Vasil");

        Collection<Pizza> find_pizzas = pizzaRepo.findAll();
        Collection<Pizza> sel_pizzas = new ArrayList<>();

        Iterator<Pizza> it = find_pizzas.iterator();
        sel_pizzas.add(it.next());
        sel_pizzas.add(it.next());
        sel_pizzas.add(it.next());




        Order.OrderBuilder builder = new Order.OrderBuilder();
        builder.setClient(client);
        builder.setPizzas(sel_pizzas);
        builder.setId(0l);
        builder.setTotal(BigDecimal.valueOf(100l));
        builder.setStatus(Status.NEW);

        Order order = builder.build();

        System.out.println(order);


       // PizzaRepository pizzaRepository = new InMemPizzaRepository();
       // PizzaService pizzaService = new SimplePizzaService(pizzaRepository);
       // OrderRepository orderRepository =new InMemOrderRepository();


    }
}
