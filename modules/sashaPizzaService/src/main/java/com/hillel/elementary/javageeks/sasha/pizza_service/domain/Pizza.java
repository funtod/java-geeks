package com.hillel.elementary.javageeks.sasha.pizza_service.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Pizza {
    private final Long id;
    private final String name;
    private final BigDecimal price;

    public Pizza(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.id) &&
                Objects.equals(name, pizza.name) &&
                Objects.equals(price, pizza.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
