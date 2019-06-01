package com.hillel.elementary.javageeks.sasha.pizza_service.services;


import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Client;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Order;

public interface OrderService {

     Order placeNewOrder(Client client, Long... idsOfPizzas);
     Order findById(Long id);
}
