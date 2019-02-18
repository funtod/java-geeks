package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.repositories.CustomerRepo;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Component("customerService")
public class DefaultCustomerService implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultCustomerService.class);
    private CustomerRepo customerRepo;

    public DefaultCustomerService(CustomerRepo customerRepo) {
        if (customerRepo == null) {
            String msg = "CustomerRepo must not be null";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        if (customer == null) {
            String msg = "Customer can not be null";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        if (customer.getName() == null || customer.getName().isEmpty() || customer.getName().trim().isEmpty()) {
            String msg = "Can not save customer with such name";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        return customerRepo.save(customer);
    }

    @Override
    public Customer registerCustomer(String customerName, String pass, String phone) {
        if (customerName == null ||
                customerName.isEmpty() ||
                pass == null ||
                pass.isEmpty() ||
                phone == null ||
                phone.isEmpty()) {
            String msg = "Can not create and save customer name:" + customerName + ",pass:" + pass + ",phone:" + phone;
            LOGGER.error(msg);
            return null;
        } else {
            if (customerRepo.getCustomerByName(customerName) != null) {
                return null;
            } else {
                return customerRepo.save(new Customer(customerName, DigestUtils.md5Hex(pass), phone));
            }
        }
    }

    @Override
    public Customer registerCustomer(String customerName) {
        if (customerName == null || customerName.isEmpty() || customerName.trim().isEmpty()) {
            String msg = "Can not create and save customer with such name";
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
        return customerRepo.save(new Customer(customerName));
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        return customerRepo.getAll();
    }


    @Override
    public Customer signIn(String name, String pass) {
        if (name == null || pass == null || name.isEmpty() || pass.isEmpty()) {
            String msg = "can't sign in user with name:" + name + ", pass:" + pass;
            LOGGER.error(msg);
            return null;
        } else {
            Customer customer = customerRepo.getCustomerByName(name);
            if (customer == null) {
                return null;
            } else if (customer.getPassword().equals(DigestUtils.md5Hex(pass))) {
                return customer;
            }
        }
        return null;
    }
}
