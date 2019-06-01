package com.hillel.elementary.javageeks.sasha.pizza_service.services;


import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Client;
import com.hillel.elementary.javageeks.sasha.pizza_service.repository.ClientRepository;

public class SimpleClientService implements ClientService {
    private ClientRepository clientRepository;

    public SimpleClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client register(Client client){

        if(client == null) {
            throw new IllegalArgumentException("client is null");
        }
        if(client.getId() != null){
            throw new IllegalArgumentException("client should not have id");
        }
        if (clientRepository.findByName(client.getName()) != null){
            throw new IllegalArgumentException("this name is taken");
        }

        return clientRepository.save(client);
    }
    @Override
        public Client findById(Long id){
        return clientRepository.findById(id);
    }
    @Override
    public Client findByName(String name){
        return clientRepository.findByName(name);
    }
}
