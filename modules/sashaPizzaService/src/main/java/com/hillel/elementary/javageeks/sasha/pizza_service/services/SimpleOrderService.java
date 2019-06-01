package com.hillel.elementary.javageeks.sasha.pizza_service.services;



import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Client;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.sasha.pizza_service.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SimpleOrderService implements OrderService {
    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private ChefService chefService;


    @Override
    public Order placeNewOrder(Client client, Long... idsOfPizzas){
        if(client == null){
            throw new IllegalArgumentException("client is null");
        }
        if(client.getId() == null){
            throw new IllegalArgumentException("client is not registration");
        }
        if(idsOfPizzas.length == 0){
            throw new IllegalArgumentException("id of pizzas is absent");
        }
        List<Pizza> list = new ArrayList<>();
        for (Long id:idsOfPizzas) {
            list.add(pizzaService.getById(id));
        }
        list = Collections.unmodifiableList(list);
        BigDecimal total = calculationTotal(list);

        /*
        Order order = new Order(null,client,list,total, Status.NEW);
        order = orderRepository.save(order);
        //chefService.cook(order);
        return order;
        */

        return null;
    }
    public  Order findById(Long id){
        return orderRepository.findById(id);
    }

    private BigDecimal calculationTotal(Collection<Pizza> collection){
        BigDecimal total = BigDecimal.ZERO;
        for (Pizza pizza:collection){
           total = total.add(pizza.getPrice());
        }
        return total;
    }
}
