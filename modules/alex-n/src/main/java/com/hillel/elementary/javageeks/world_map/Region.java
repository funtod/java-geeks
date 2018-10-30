package com.hillel.elementary.javageeks.world_map;

public class Region {
    private String name;
    private long square;
    private City regionCenter;
    private City[] cities;

    public Region(String name, City regionCenter, long square, City[] cities) {
        this.name = name;
        this.regionCenter = regionCenter;
        this.square = square;
        this.cities = cities;
    }

    public City getRegionCenter() {
        return regionCenter;
    }

    public void setRegionCenter(City regionCenter) {
        this.regionCenter = regionCenter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSquare() {
        return square;
    }

    public void setSquare(long square) {
        this.square = square;
    }

    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }
}
