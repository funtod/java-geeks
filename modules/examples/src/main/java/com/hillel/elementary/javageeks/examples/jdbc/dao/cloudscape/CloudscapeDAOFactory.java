package com.hillel.elementary.javageeks.examples.jdbc.dao.cloudscape;

import com.hillel.elementary.javageeks.examples.jdbc.dao.CustomerDAO;
import com.hillel.elementary.javageeks.examples.jdbc.dao.DAOFactory;
import com.hillel.elementary.javageeks.examples.jdbc.dao.mysql.MysqlCustomerDAO;

import java.sql.Connection;

public class CloudscapeDAOFactory extends DAOFactory {

    public static final String DRIVER = "COM.cloudscape.core.RmiJdbcDriver";
    public static final String DBURL = "jdbc:cloudscape:rmi://localhost:1099/CoreJ2EEDB";

    public static Connection createConnection() {
        throw new UnsupportedOperationException();
    }

    public CustomerDAO getCustomerDAO() {
        return new CloudscapeCustomerDAO();
    }
}