package com.hillel.elementary.javageeks.examples.jdbc.dao.cloudscape;


import com.hillel.elementary.javageeks.examples.jdbc.dao.Customer;
import com.hillel.elementary.javageeks.examples.jdbc.dao.CustomerDAO;

public class CloudscapeCustomerDAO implements CustomerDAO {

    @Override
    public Long insertCustomer(Customer customer) {
        return null;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer findCustomer(Long id) {
        return null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }
}
