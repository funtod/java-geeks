package com.hillel.elementary.javageeks.examples.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeroCaller {

    public static<E extends Hero> List<HeroResponse> callAllHeroes(List<E> heroes) {
        ArrayList<HeroResponse> responses = new ArrayList<>();
        for (E hero : heroes) {
           responses.add(hero.call());
        }
        return responses;
    }

    public static void main(String[] args) {
        ArrayList<SuperHero> heroes = new ArrayList<>();
        heroes.add(new SuperHero("b", "r"));
        heroes.add(new SuperHero("c", "n"));
        heroes.add(new SuperHero("d", "b"));

        List<HeroResponse> heroResponses = HeroCaller.callAllHeroes(heroes);
        System.out.println(heroResponses);
    }

}
