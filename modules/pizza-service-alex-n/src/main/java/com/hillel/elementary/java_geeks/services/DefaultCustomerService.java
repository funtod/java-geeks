package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.repositories.CustomerRepo;

import java.util.Collection;

@Component("customerService")
public class DefaultCustomerService implements CustomerService {

    private CustomerRepo customerRepo;

    public DefaultCustomerService(CustomerRepo customerRepo) {
        if (customerRepo == null) {
            throw new IllegalArgumentException("CustomerRepo must not be null");
        }
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer can not be null");
        }
        if (customer.getName() == null || customer.getName().isEmpty() || customer.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Can not save customer with such name.");
        }
        return customerRepo.save(customer);
    }

    @Override
    public Customer registerCustomer(String customerName) {
        if (customerName == null || customerName.isEmpty() || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Can not create and save customer with such name.");
        }
        return customerRepo.save(new Customer(customerName));
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerRepo.getAll();
    }
}
