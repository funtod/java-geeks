package com.hillel.elementary.javageeks.world_map;

public class Country {
    private City capital;
    private Region[] regions;

    public Country(City capitalName, Region[] regionsArray) {
        this.capital = capitalName;
        this.regions = regionsArray;
    }

    public final long getSquare() {
        long square = 0;
        for (int i = 0; i < regions.length; i++) {
            square += regions[i].getSquare();
        }
        return square;
    }

    public final int getRegionsNumber() {
        return regions.length;
    }

    public final City[] getRegionCenters() {
        City[] regionCenters = new City[regions.length];
        for (int i = 0; i < regions.length; i++) {
            regionCenters[i] = regions[i].getRegionCenter();
        }
        return regionCenters;
    }

    public final City getCapital() {
        return capital;
    }

    public final void setCapital(City capitalName) {
        this.capital = capitalName;
    }

    public final Region[] getRegions() {
        return regions;
    }

    public final void setRegions(Region[] regionsArray) {
        this.regions = regionsArray;
    }
}
