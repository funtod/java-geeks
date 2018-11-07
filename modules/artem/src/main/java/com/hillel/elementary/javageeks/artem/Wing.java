package com.hillel.elementary.javageeks.artem;

public class Wing  {
    private int quantity;
    private String name;

    public Wing(int quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "  quantity="+this.quantity+", name="+this.name;
    }
}
