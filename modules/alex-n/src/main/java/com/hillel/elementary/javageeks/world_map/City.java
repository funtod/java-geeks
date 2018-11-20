package com.hillel.elementary.javageeks.world_map;

import java.util.Arrays;

public class City {
    private String name;
    private District[] districts;

    public final String getName() {
        return name;
    }

    public final void setName(String cityName) {
        this.name = cityName;
    }

    public final District[] getDistricts() {
        return districts;
    }

    public final void setDistricts(District[] districtsArray) {
        this.districts = districtsArray;
    }

    public City(String cityName, District[] districtsArray) {
        this.name = cityName;
        this.districts = districtsArray;
    }

    @Override
    public String toString() {
        return "City{" + "name='" + name + "\' , districts=" + Arrays.toString(districts) + "}";
    }
}
