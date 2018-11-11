package com.hillel.elementary.javageeks.ruslanTask4;


public class Wing {

    String name;
    String manufacturer;

    public Wing(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
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
        return " Wing [name=" + name + ", manufacturer=" + manufacturer + "]";
    }

}