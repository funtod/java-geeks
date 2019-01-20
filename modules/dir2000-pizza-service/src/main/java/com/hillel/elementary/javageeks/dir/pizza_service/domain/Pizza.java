package com.hillel.elementary.javageeks.dir.pizza_service.domain;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.enums.PizzaType;

import java.math.BigDecimal;
import java.util.Objects;

public class Pizza {
    private final Long id;
    private final String name;
    private final PizzaType pizzaType;
    private final int millisecondsToCook;
    private final BigDecimal price;

    public Pizza(Long argId, String argName, PizzaType argPizzaType, int argMillisecondsToCook, BigDecimal argPrice) {
        id = argId;
        name = argName;
        pizzaType = argPizzaType;
        millisecondsToCook = argMillisecondsToCook;
        price = argPrice;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object argO) {
        if (this == argO) {
            return true;
        }
        if (argO == null || getClass() != argO.getClass()) {
            return false;
        }
        Pizza pizza = (Pizza) argO;
        return Objects.equals(id, pizza.id);
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
