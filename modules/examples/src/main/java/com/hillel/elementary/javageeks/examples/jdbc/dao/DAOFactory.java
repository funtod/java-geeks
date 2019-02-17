package com.hillel.elementary.javageeks.examples.jdbc.dao;

import com.hillel.elementary.javageeks.examples.jdbc.dao.mysql.MysqlCustomerDAO;
import com.hillel.elementary.javageeks.examples.jdbc.dao.mysql.MysqlDaoFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class DAOFactory {

    enum FactoryType {
        CLOUDSCAPE,
        MYSQL,
        ORACLE,
        SYBASE
    }

    private static Map<FactoryType, DAOFactory> factories = new HashMap<>();

    public abstract CustomerDAO getCustomerDAO();

    public static DAOFactory getDAOFactory(FactoryType whichFactory) {
        switch (whichFactory) {
            case CLOUDSCAPE:
                return getDaoFactory(FactoryType.CLOUDSCAPE);
            case MYSQL:
                return getDaoFactory(FactoryType.MYSQL);
//            case ORACLE:
//                return new OracleDAOFactory();
//            case SYBASE:
//                return new SybaseDAOFactory();
            default:
                throw new IllegalArgumentException("Unkown DAOFactory type: " + whichFactory);
        }
    }

    private static DAOFactory getDaoFactory(FactoryType type) {
        return factories.computeIfAbsent(type, (any) -> new MysqlDaoFactory());
    }

}