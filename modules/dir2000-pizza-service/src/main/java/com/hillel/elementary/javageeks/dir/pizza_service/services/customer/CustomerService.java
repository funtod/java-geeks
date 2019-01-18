package com.hillel.elementary.javageeks.dir.pizza_service.services.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;

public interface CustomerService {
    Customer getById(Long id);

    Customer register(Customer customer);

    Customer getByName(String name);
}
