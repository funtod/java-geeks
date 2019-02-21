package com.hillel.elementary.java_geeks.domain;

import java.util.Objects;

public class Customer {
    private Long id;
    private String name;
    private String password;
    private String phone;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(Long id, String name, String password, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public Customer(String name, String password, String phone) {
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
