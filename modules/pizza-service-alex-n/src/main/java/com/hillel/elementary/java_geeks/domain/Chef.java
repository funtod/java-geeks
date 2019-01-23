package com.hillel.elementary.java_geeks.domain;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class Chef {

    private Integer id;
    private String name;
    private ChefWorkingStatus workingStatus;
    private Collection<Order> orders;

    public Chef(Integer id, String name, ChefWorkingStatus workingStatus, Collection<Order> orders) {
        this.id = id;
        this.name = name;
        this.workingStatus = workingStatus;
        if (orders == null) {
            this.orders = new LinkedList<>();
        } else {
            this.orders = orders;
        }
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ChefWorkingStatus getStatus() {
        return workingStatus;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Chef chef = (Chef) o;
        return Objects.equals(id, chef.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
