package com.hillel.elementary.javageeks.examples.jdbc.dao;

public interface CustomerDAO {

    public Long insertCustomer(Customer customer);

    public boolean deleteCustomer(Customer customer);

    public Customer findCustomer(Long id);

    public boolean updateCustomer(Customer customer);

}