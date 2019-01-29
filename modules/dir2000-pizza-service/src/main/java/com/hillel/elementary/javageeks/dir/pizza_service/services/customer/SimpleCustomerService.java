package com.hillel.elementary.javageeks.dir.pizza_service.services.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer.CustomerRepository;

import java.util.Optional;

@Component("customerService")
public class SimpleCustomerService implements CustomerService {
    private final CustomerRepository repository;

    public SimpleCustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer getById(Long id) {
        Optional<Customer> result = repository.findById(id);
        result.orElseThrow(() ->new IllegalStateException("Could not get customer by id " + id));
        return result.get();
    }

    @Override
    public Customer getByName(String name) {
        Optional<Customer> result = repository.findByName(name);
        if (result.isPresent()) {
            return result.get();
        }
        return null;
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

        Optional<Customer> result = repository.save(customer);
        result.orElseThrow(() ->new IllegalStateException("Failed to save customer " + customer));
        return result.get();
    }
}
