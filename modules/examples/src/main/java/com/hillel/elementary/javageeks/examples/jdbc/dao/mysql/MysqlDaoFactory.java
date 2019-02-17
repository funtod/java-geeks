package com.hillel.elementary.javageeks.examples.jdbc.dao.mysql;

import com.hillel.elementary.javageeks.examples.jdbc.dao.DAOFactory;

public class MysqlDaoFactory extends DAOFactory {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/pizzas";
    private String jdbcPassword = "password";
    private String jdbcUserName = "pizzas_user";


    @Override
    public MysqlCustomerDAO getCustomerDAO() {
        return new MysqlCustomerDAO(jdbcUrl, jdbcUserName, jdbcPassword);
    }
}
