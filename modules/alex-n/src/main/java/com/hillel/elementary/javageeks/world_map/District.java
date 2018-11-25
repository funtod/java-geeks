package com.hillel.elementary.javageeks.world_map;

public class District {

    private String name;

    public District(String districtName) {
        this.name = districtName;
    }

    public final void setName(String districtName) {
        this.name = districtName;
    }

    public final String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "District{ name=" + name + "\'}";
    }
}
