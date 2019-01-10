package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Customer;

import java.util.HashMap;

public class InMemCustomerRepo implements CustomerRepo {

    HashMap<Long, Customer> customers = new HashMap<>();
    Long counter = 0L;

    @Override
    public Customer save(Customer customer) {
        Customer savedCustomer = new Customer(counter, customer.getName());
        customers.put(counter, savedCustomer);
        counter++;
        return savedCustomer;
    }
}
