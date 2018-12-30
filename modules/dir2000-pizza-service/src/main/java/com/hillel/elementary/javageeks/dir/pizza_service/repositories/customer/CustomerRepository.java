package com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;

public interface CustomerRepository {
    Customer findById(Long id);

    Customer save(Customer customer);

    Customer findByName(String name);
}
