package com.hillel.elementary.javageeks.examples.jdbc;

import java.sql.*;

public class TransactionExample {

    public static void main(String[] args) throws SQLException {
        Statement statement = null;

        Long id = 15512L;
        String name = "Vasya";

        try(Connection connection = DriverManager.getConnection(DbConfig.URL, DbConfig.username, DbConfig.password);) {
            statement = connection.createStatement();
            String upd = "INSERT INTO student (id, name) VALUES ('"+ id + "', '" + name + "')";

            try {
                statement.executeUpdate(upd);
                connection.commit();
            } catch (Exception e) {
                System.out.println("Error executing update " + e);
                connection.rollback();
            }
        } catch (Exception e) {
            System.out.println("Error connecting to database " + e);
        } finally {
            if (statement != null) statement.close();
        }
    }
}
