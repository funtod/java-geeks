package com.hillel.elementary.javageeks.examples.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UtilityTest {

    @Test
    void shouldFillAListWithValues() {
        //given
        ArrayList<Hero> list = new ArrayList<>();
        list.add(new SuperHero("b", "r"));
        list.add(new SuperHero("c", "n"));
        list.add(new SuperHero("d", "b"));

        //when
        Utility.fill(list, new Hero("a"));

        //then
        assertThat(list.get(0)).isEqualTo(new Hero("a"));
    }

    @Test
    void shouldRevertRawType() {
        List list = new ArrayList();
        list.add("a");
        list.add(1);


        Collections.reverse(list);

        Utility.revert(list);

        System.out.println(list);
    }
}