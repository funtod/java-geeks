package com.hillel.elementary.javageeks.world_map;

import java.util.Arrays;

public class City {
    private String name;
    private District[] districts;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District[] districts) {
        this.districts = districts;
    }

    public City(String name, District[] districts){
        this.name = name;
        this.districts = districts;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", districts=" + Arrays.toString(districts) +
                '}';
    }
}
