package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Customer;

import java.util.Collection;

public interface CustomerRepo {

    Customer save(Customer customer);

    Collection<Customer> getAll();
}
