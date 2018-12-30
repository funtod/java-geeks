package com.hillel.elementary.javageeks.dir.pizza_service.services.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer.CustomerRepository;

public class SimpleCustomerService implements CustomerService {
    CustomerRepository repository;

    public SimpleCustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Customer getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Customer register(Customer customer) {
        return repository.save(customer);
    }
}
