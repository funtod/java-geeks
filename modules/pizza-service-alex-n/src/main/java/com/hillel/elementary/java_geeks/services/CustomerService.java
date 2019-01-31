package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Customer;

import java.util.Collection;

public interface CustomerService {

    Customer registerCustomer(Customer customer);

    Customer registerCustomer(String customerName);

    Collection<Customer> getAllCustomers();
}
