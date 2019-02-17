package com.hillel.elementary.javageeks.examples.jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BatchExample {

    public static void main(String[] args) throws SQLException {
        PreparedStatement statement = null;
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DbConfig.URL, DbConfig.username, DbConfig.password);) {
            statement = connection.prepareStatement("INSERT INTO employee VALUES (?,?,?,?,?)");
            for (Employee currEmployee : employees) {

                statement.setString(1, currEmployee.getSsn());
                statement.setString(2, currEmployee.getName());
                statement.setDouble(3, currEmployee.getSalary());
                statement.setString(4, currEmployee.getHireDate().toString());
                statement.setLong(5, currEmployee.getId());

                statement.addBatch();
            }
            int[] updateCounts = statement.executeBatch();

        } catch (Exception e) {
            System.out.println("Error connecting to database " + e);
        } finally {
            if (statement != null) statement.close();
        }
    }

        static class Employee {
            private Long id;
            private String ssn;
            private String name;
            private Double salary;
            private LocalDate hireDate;

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getSsn() {
                return ssn;
            }

            public void setSsn(String ssn) {
                this.ssn = ssn;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Double getSalary() {
                return salary;
            }

            public void setSalary(Double salary) {
                this.salary = salary;
            }

            public LocalDate getHireDate() {
                return hireDate;
            }

            public void setHireDate(LocalDate hireDate) {
                this.hireDate = hireDate;
            }
        }

    }
