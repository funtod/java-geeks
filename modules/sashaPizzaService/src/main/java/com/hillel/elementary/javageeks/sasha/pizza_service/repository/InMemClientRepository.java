package com.hillel.elementary.javageeks.sasha.pizza_service.repository;


import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Client;

import java.util.HashMap;
import java.util.Map;

public class InMemClientRepository implements ClientRepository {

    private Map<Long, Client>clients = new HashMap<>();
    private Long counter = 0l;

    @Override
    public synchronized Client findById(Long id){
        return clients.get(id);
    }

    @Override
    public synchronized Client save(Client client){
        if(client == null)throw new NullPointerException();
        Client clientToSave;
        if(client.getId() == null){
            clientToSave = new Client(++counter,client.getName());
        }else if(clients.get(client.getId()) == null){
            throw new IllegalArgumentException("");
        }else {
            clientToSave = client;
        }
        clients.put(clientToSave.getId(),clientToSave);

        return clientToSave;
    }
    public synchronized Client findByName(String name){
        for (Client client : clients.values()) {
            if(client.getName().equals(name)){
                return client;
            }
        }
        return null;
    }
}
