package com.hillel.elementary.javageeks.sasha.pizza_service.services;



import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Client;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Status;
import com.hillel.elementary.javageeks.sasha.pizza_service.repository.OrderRepository;
import com.hillel.elementary.javageeks.sasha.pizza_service.repository.PizzaRepository;

import java.math.BigDecimal;
import java.util.Collection;

public class SimplePizzaService implements PizzaService {

    private PizzaRepository pizzaRepository;
    private OrderRepository orderRepository;

    public SimplePizzaService(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Collection<Pizza> getAll() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getById(Long id) {
        return pizzaRepository.findById(id);
    }

    @Override
    public Order placeOrder(Client client, Collection<Pizza> pizzas) {
        if (client == null){
            throw new IllegalArgumentException("client is null");
        }
        if(client.getId() == null){
            throw new IllegalArgumentException("client is not registered");
        }
        if (pizzas == null){
            throw new IllegalArgumentException("pizza is null");
        }
        if (pizzas.isEmpty()){
            throw new IllegalArgumentException("pizza is empty");
        }

        BigDecimal orderTotal = calculateTotal(pizzas);

        Order order = new Order.OrderBuilder()
                .setClient(client)
                .setPizzas(pizzas)
                .setTotal(orderTotal)
                .setStatus(Status.NEW)
                .build();

        return orderRepository.save(order);
    }

    private BigDecimal calculateTotal(Collection<Pizza> pizzas) {
        BigDecimal total = BigDecimal.ZERO;
        for (Pizza pizza : pizzas) {
            total = total.add(pizza.getPrice());
        }
        return total;
    }

}
