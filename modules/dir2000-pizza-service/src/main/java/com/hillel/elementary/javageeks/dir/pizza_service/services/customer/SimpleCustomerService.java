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
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null.");
        }
        if (customer.getId() != null) {
            throw new IllegalArgumentException("Customer should not have id.");
        }
        if (getByName(customer.getName()) != null) {
            throw new IllegalArgumentException(String.format("%s name is taken.", customer.getName()));
        }

        return repository.save(customer);
    }
}
