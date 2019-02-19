package com.hillel.elementary.javageeks.examples.jdbc.dao.mysql;


import com.hillel.elementary.javageeks.examples.jdbc.dao.Customer;
import com.hillel.elementary.javageeks.examples.jdbc.dao.CustomerDAO;

import java.sql.*;

public class MysqlCustomerDAO implements CustomerDAO {

    private String jdbcUrl;
    private String jdbcUserName;
    private String jdbcPassword;


    public MysqlCustomerDAO(String jdbcUrl, String jdbcUserName, String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
        this.jdbcUrl = jdbcUrl;
        this.jdbcUserName = jdbcUserName;
    }

    @Override
    public Long insertCustomer(Customer customer) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customer (name, streetAddress, city) VALUES(?,?,?);");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getStreetAddress());
            preparedStatement.setString(3, customer.getCity());
            preparedStatement.executeUpdate();
            ResultSet resultSet = connection.prepareStatement("SELECT LAST_INSERT_ID();").executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer findCustomer(Long id) {
        Customer customer = null;
        try(Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer WHERE id=?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            customer = mapCustomer(id, resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    private Customer mapCustomer(Long id, ResultSet resultSet) throws SQLException {
        Customer tmpCustomer = new Customer();
        tmpCustomer.setCustomerNumber(id);
        resultSet.next();
        tmpCustomer.setName(resultSet.getString(1));
        tmpCustomer.setStreetAddress(resultSet.getString(3));
        tmpCustomer.setCity(resultSet.getString(4));
        return tmpCustomer;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try(Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customer  set name=?, streetAddress=?, city=? WHERE id=?");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setLong(4, customer.getCustomerNumber());
            preparedStatement.setString(2, customer.getStreetAddress());
            preparedStatement.setString(3, customer.getCity());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
