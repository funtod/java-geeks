package com.hillel.elementary.javageeks.examples.jdbc;

import java.sql.*;

public class CallableStatementExample {

    public static void main(String[] args) throws SQLException {
        CallableStatement statement = null;

        try (Connection connection = DriverManager.getConnection(DbConfig.URL, DbConfig.username, DbConfig.password);) {
            String SQL = "{call getempname (?,?)}";
            statement = connection.prepareCall(SQL);
            int ssn = 822301;
            statement.setInt(1, ssn);
            //регистрация выходящего параметра
            statement.registerOutParameter(2, Types.VARCHAR);
            statement.execute();
            String empName = statement.getString(2);
            System.out.println("Employee with SSN:" + ssn + " is " + empName);

        } catch (Exception e) {
            System.out.println("Error connecting to database " + e);
        } finally {
            if (statement != null) statement.close();
        }
    }
}
