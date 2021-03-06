package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.domain.Customer;

import java.util.Collection;
import java.util.HashMap;


@Component("customerRepo")
public class InMemCustomerRepo implements CustomerRepo {

    private HashMap<Long, Customer> customers = new HashMap<>();
    private Long counter = 0L;

    @Override
    public Customer save(Customer customer) {
        Customer savedCustomer = new Customer(counter, customer.getName());
        customers.put(counter, savedCustomer);
        counter++;
        return savedCustomer;
    }

    @Override
    public Collection<Customer> getAll() {
        return customers.values();
    }
}
