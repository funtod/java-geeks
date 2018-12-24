package com.hillel.elementary.javageeks.dir.pizza_service.domain;

import java.math.BigDecimal;

public class Pizza {
    private Long id;
    private String name;
    private PizzaType pizzaType;
    private int millisecondsToCook;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public int getMillisecondsToCook() {
        return millisecondsToCook;
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
                ", millisecondsToCook=" + millisecondsToCook +
                ", price=" + price +
                '}';
    }
}
