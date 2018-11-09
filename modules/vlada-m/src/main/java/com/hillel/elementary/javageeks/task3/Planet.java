package com.hillel.elementary.javageeks.task3;

public class Planet {
    private String name;
    private Ocean[] oceans;
    private Continent[] continents;
    private Island[] islands;

    public Planet(String name, Ocean[] oceans, Continent[] continents, Island[] islands) {
        this.name = name;
        this.oceans = oceans;
        this.continents = continents;
        this.islands = islands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ocean[] getOceans() {
        return oceans;
    }

    public void setOceans(Ocean[] oceans) {
        this.oceans = oceans;
    }

    public Continent[] getContinents() {
        return continents;
    }

    public void setContinents(Continent[] continents) {
        this.continents = continents;
    }

    public Island[] getIslands() {
        return islands;
    }

    public void setIslands(Island[] islands) {
        this.islands = islands;
    }
    public int getNumberOfContinents(){
        return continents.length;
    }

}
