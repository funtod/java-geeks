package com.hillel.elementary.java_geeks.domain;

import java.math.BigDecimal;
import java.util.HashMap;

public class Discount {

    private boolean totalDiscountEnabled;
    private BigDecimal totalDiscountStartsSum;
    private BigDecimal totalDiscount;

    private boolean pizzaDiscountEnabled;
    private HashMap<Integer, Integer> monthPizza;
    private BigDecimal pizzaDiscount;

    private boolean thirdPizzaFreeEnabled;

    public Discount(boolean totalDiscountEnabled,
                    BigDecimal totalDiscountStartsSum,
                    BigDecimal totalDiscount,
                    boolean pizzaDiscountEnabled,
                    HashMap<Integer, Integer> monthPizza,
                    BigDecimal pizzaDiscount,
                    boolean thirdPizzaFreeEnabled) {
        this.totalDiscountEnabled = totalDiscountEnabled;
        this.totalDiscountStartsSum = totalDiscountStartsSum;
        this.totalDiscount = totalDiscount;
        this.pizzaDiscountEnabled = pizzaDiscountEnabled;
        this.monthPizza = monthPizza;
        this.pizzaDiscount = pizzaDiscount;
        this.thirdPizzaFreeEnabled = thirdPizzaFreeEnabled;
    }

    public boolean isTotalDiscountEnabled() {
        return totalDiscountEnabled;
    }

    public BigDecimal getTotalDiscountStartsSum() {
        return totalDiscountStartsSum;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public boolean isPizzaDiscountEnabled() {
        return pizzaDiscountEnabled;
    }

    public HashMap<Integer, Integer> getMonthPizza() {
        return monthPizza;
    }

    public BigDecimal getPizzaDiscount() {
        return pizzaDiscount;
    }

    public boolean isThirdPizzaFreeEnabled() {
        return thirdPizzaFreeEnabled;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "totalDiscountEnabled=" + totalDiscountEnabled +
                ", totalDiscountStartsSum=" + totalDiscountStartsSum +
                ", totalDiscount=" + totalDiscount +
                ", pizzaDiscountEnabled=" + pizzaDiscountEnabled +
                ", monthPizza=" + monthPizza +
                ", pizzaDiscount=" + pizzaDiscount +
                ", thirdPizzaFreeEnabled=" + thirdPizzaFreeEnabled +
                '}';
    }
}
