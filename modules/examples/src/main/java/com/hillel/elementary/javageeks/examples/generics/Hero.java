package com.hillel.elementary.javageeks.examples.generics;

import java.util.Objects;

public class Hero {
    private final String name;


    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HeroResponse call() {
        return new HeroResponse();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hero hero = (Hero) o;
        return Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
