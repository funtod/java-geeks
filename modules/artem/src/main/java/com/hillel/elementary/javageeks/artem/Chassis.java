package com.hillel.elementary.javageeks.artem;

public class Chassis {
    private int quantity;

    public Chassis(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "  quantity="+this.quantity;
    }
}
