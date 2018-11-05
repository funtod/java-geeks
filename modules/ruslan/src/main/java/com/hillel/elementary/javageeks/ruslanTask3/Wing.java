package com.hillel.elementary.javageeks.ruslanTask3;

public class Wing {

    int count;
    String name;
    String manufacturer;

    public Wing(int count, String name, String manufacturer) {
        this.count = count;
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return " Wing [count=" + count + ", name=" + name + ", manufacturer=" + manufacturer + "]";
    }

}
