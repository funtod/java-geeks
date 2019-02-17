package com.hillel.elementary.javageeks.examples.jdbc;

import java.sql.*;

public class JdbcConnectionExample {

    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;

        try(Connection connection = DriverManager.getConnection(DbConfig.URL, DbConfig.username, DbConfig.password);) {
            if (connection != null) System.out.println("Connection Successful !\n");
            else {
                System.out.println("Error connecting to database");
                return;
            }

            statement = connection.createStatement();
            //ResultSet получает результирующую таблицу
            resultSet = statement.executeQuery("select hd from pc group by hd having count(hd)>=2");

            //Resultset.getMetaData() получаем информацию о результирующей таблице
            int columnCount = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error connecting to database " + e);
        } finally {
            if (statement != null) statement.close();
            if (resultSet != null) resultSet.close();
        }
    }
}
