package com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(Long id);

    Optional<Customer>  save(Customer customer);

    Optional<Customer> findByName(String name);
}
