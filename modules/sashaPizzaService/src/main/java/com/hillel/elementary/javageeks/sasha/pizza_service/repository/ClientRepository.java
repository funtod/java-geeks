package com.hillel.elementary.javageeks.sasha.pizza_service.repository;

import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Client;

public interface ClientRepository {
    Client findById(Long id);
    Client save(Client client);
    Client findByName(String name);
}
