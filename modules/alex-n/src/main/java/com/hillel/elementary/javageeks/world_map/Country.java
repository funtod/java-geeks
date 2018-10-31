package com.hillel.elementary.javageeks.world_map;

public class Country {
    private City capital;
    private Region[] regions;

    public Country(City capital, Region[] regions) {
        this.capital = capital;
        this.regions = regions;
    }

    public long getSquare(){
        long square = 0;
        for (int i = 0; i < regions.length; i++) {
            square += regions[i].getSquare();
        }
        return square;
    }

    public int getRegionsNumber(){
        return regions.length;
    }

    public City[] getRegionCenters(){
        City[] regionCenters = new City[regions.length];
        for (int i = 0; i < regions.length; i++) {
            regionCenters[i] = regions[i].getRegionCenter();
        }
        return regionCenters;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }
}
