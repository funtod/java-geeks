package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.repositories.CustomerRepo;

public class DefaultCustomerService implements CustomerService {

    private CustomerRepo customerRepo;

    public DefaultCustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer registerCustomer(String customerName) {
        return customerRepo.save(new Customer(customerName));
    }
}
