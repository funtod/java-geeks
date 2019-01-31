package com.hillel.elementary.javageeks.sasha.pizza_service.services;


import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Client;

public interface ClientService {
    Client register(Client client);
    Client findById(Long id);
    Client findByName(String name);

}
