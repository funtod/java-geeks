package com.hillel.elementary.javageeks.task3;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {
    private static Planet planet;

    @BeforeEach
    public  void init() {
        Ocean[] oceans = new Ocean[5];
        oceans[0] = new Ocean("Northern Ice");
        oceans[1] = new Ocean("Atlantic");
        oceans[2] = new Ocean("Pacific");
        oceans[3] = new Ocean("Indian");
        oceans[4]= new Ocean("Southern");
        Continent[] continents = new Continent[6];
        continents[0] = new Continent("Eurasia");
        continents[1] = new Continent("Northern America");
        continents[2] = new Continent("Southern America");
        continents[3] = new Continent("Africa");
        continents[4] = new Continent("Australia");
        continents[5] = new Continent("Antarctica");
        Island[] islands = new Island[7];
        islands[0] = new Island("Ireland");
        islands[1] = new Island("Great Britain");
        islands[2] = new Island("Java");
        islands[3] = new Island("Manhattan");
        islands[4] = new Island("Greenland");
        islands[5] = new Island("Iceland");
        islands[6] = new Island("Sicily");
        planet = new Planet("Earth", oceans, continents, islands);
    }

    @Test
    void shouldGetName() {
        String name = planet.getName();
        assertEquals("Earth", name);
    }

    @Test
    void shouldSetName() {
        assertEquals("Earth", planet.getName());
        //when
        planet.setName("Mars");
        //then
        assertEquals("Mars", planet.getName());
    }

    @Test
    void shouldGetOceans() {
        Ocean[] oceans = planet.getOceans();
        assertEquals("Northern Ice", oceans[0].getName());
        assertEquals("Atlantic", oceans[1].getName());
        assertEquals("Pacific", oceans[2].getName());
        assertEquals("Indian", oceans[3].getName());
        assertEquals("Southern", oceans[4].getName());
    }

    @Test
    void shouldSetOceans() {
        Ocean[]oceans = new Ocean[2];
        oceans[0] =new Ocean("FakeOcean1");
        oceans[1] = new Ocean("FakeOcean2");
        planet.setOceans(oceans);
        assertEquals("FakeOcean1",planet.getOceans()[0].getName());
        assertEquals("FakeOcean2", planet.getOceans()[1].getName());
        }


    @Test
    void shouldGetContinents() {
        Continent[] continents = planet.getContinents();
        assertEquals("Eurasia",continents[0].getName());
        assertEquals("Northern America",continents[1].getName());
        assertEquals("Southern America",continents[2].getName());
        assertEquals("Africa", continents[3].getName());
        assertEquals("Australia", continents[4].getName());
        assertEquals("Antarctica", continents[5].getName());

    }

    @Test
    void shouldSetContinents() {
        Continent[]continents = new Continent[2];
        continents[0] = new Continent("Asia");
        continents[1] = new Continent("Europe");
        planet.setContinents(continents);
        assertEquals("Asia", continents[0].getName());
        assertEquals("Europe",continents[1].getName());
    }

    @Test
    void shouldGetIslands() {
        Island[] islands = planet.getIslands();
        assertEquals("Ireland",islands[0].getName());
        assertEquals("Great Britain", islands[1].getName());
        assertEquals("Java", islands[2].getName());
        assertEquals("Manhattan", islands[3].getName());
        assertEquals("Greenland", islands[4].getName());
        assertEquals("Iceland", islands[5].getName());
        assertEquals("Sicily", islands[6].getName());
    }

    @Test
    void shouldSetIslands() {
        Island[] islands = new Island[2];
        islands[0] = new Island("Sumatra");
        islands[1] = new Island("Trukhaniv");
        planet.setIslands(islands);
        assertEquals("Sumatra", islands[0].getName());
        assertEquals("Trukhaniv",islands[1].getName());
    }

    @Test
    void shouldGetNumberOOfContinents() {
        assertEquals(6, planet.getNumberOfContinents());
    }
}