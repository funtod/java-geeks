package com.hillel.elementary.javageeks.world_map;

public class Region {
    private String name;
    private long square;
    private City regionCenter;
    private City[] cities;

    public Region(String regionName, City regionCenterCity, long regionSquare, City[] citiesInRegionArray) {
        this.name = regionName;
        this.regionCenter = regionCenterCity;
        this.square = regionSquare;
        this.cities = citiesInRegionArray;
    }

    public final City getRegionCenter() {
        return regionCenter;
    }

    public final void setRegionCenter(City regionCenterCity) {
        this.regionCenter = regionCenterCity;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String regionName) {
        this.name = regionName;
    }

    public final long getSquare() {
        return square;
    }

    public final void setSquare(long regionSquare) {
        this.square = regionSquare;
    }

    public final City[] getCities() {
        return cities;
    }

    public final void setCities(City[] citiesInRegionArray) {
        this.cities = citiesInRegionArray;
    }
}
