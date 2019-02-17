package com.hillel.elementary.javageeks.examples.jdbc.dao;

public class DaoFactoryUsageExample {

    public static void main(String[] args) {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL);

        CustomerDAO custDAO = daoFactory.getCustomerDAO();
        Long newCustId = custDAO.insertCustomer(new Customer());

        //Создаем Customer объект
        Customer customer = custDAO.findCustomer(newCustId);

        //изменяем значение Customer объекта
        customer.setStreetAddress("Klovska str, 22");
        customer.setCity("Kyiv");
        customer.setName("Vasya");

        custDAO.updateCustomer(customer);
    }
}
