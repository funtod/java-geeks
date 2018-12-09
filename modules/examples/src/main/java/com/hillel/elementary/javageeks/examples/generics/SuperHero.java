package com.hillel.elementary.javageeks.examples.generics;

public class SuperHero extends Hero {
    private String nickName;

    public SuperHero(String name, String nickName) {
        super(name);
        this.nickName = nickName;
    }

    @Override
    public SuperHeroResponse call() {
        return new SuperHeroResponse();
    }
}
