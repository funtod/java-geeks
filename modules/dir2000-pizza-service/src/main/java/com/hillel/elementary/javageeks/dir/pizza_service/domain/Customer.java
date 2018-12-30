package com.hillel.elementary.javageeks.dir.pizza_service.domain;

import java.util.Objects;

public class Customer {
    private final Long id;
    private final String name;

    public Customer(Long argId, String argName) {
        id = argId;
        name = argName;
    }

    @Override
    public boolean equals(Object argO) {
        if (this == argO) {
            return true;
        }
        if (argO == null || getClass() != argO.getClass()) {
            return false;
        }
        Customer customer = (Customer) argO;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
