package com.hillel.elementary.java_geeks.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Pizza {

    private Integer id;
    private String name;
    private PizzaType pizzaType;
    private int cookingTime;
    private BigDecimal price;

    public Pizza(Integer id, String name, PizzaType pizzaType, int cookingTime, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.pizzaType = pizzaType;
        this.cookingTime = cookingTime;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pizzaType=" + pizzaType +
                ", cookingTime=" + cookingTime +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
