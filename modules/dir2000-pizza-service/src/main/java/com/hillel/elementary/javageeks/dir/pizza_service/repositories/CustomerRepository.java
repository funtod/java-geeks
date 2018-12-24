package com.hillel.elementary.javageeks.dir.pizza_service.repositories;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;

public interface CustomerRepository {
    Customer findById(Long id);

    Customer save(Customer order);

    Customer findByName(String name);
}
