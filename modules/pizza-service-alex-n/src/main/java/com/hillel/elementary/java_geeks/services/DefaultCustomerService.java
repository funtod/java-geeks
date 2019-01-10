package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.repositories.CustomerRepo;
import com.hillel.elementary.java_geeks.repositories.InMemCustomerRepo;

public class DefaultCustomerService implements CustomerService {

    private CustomerRepo customerRepo;

    public DefaultCustomerService() {
        customerRepo = new InMemCustomerRepo();
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return customerRepo.save(customer);
    }
}
