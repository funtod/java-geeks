package com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer.CustomerRepository;

import java.util.HashMap;

public class InMemCustomerRepository implements CustomerRepository {
    HashMap<Long, Customer> customers = new HashMap<>();

    @Override
    public Customer findById(Long id) {
        return customers.get(id);
    }

    @Override
    public Customer save(Customer order) {
        return null;
    }

    @Override
    public Customer findByName(String name) {
        return null;
    }
}
