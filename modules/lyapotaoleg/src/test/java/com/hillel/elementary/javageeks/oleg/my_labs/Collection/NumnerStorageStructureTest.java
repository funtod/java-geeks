package com.hillel.elementary.javageeks.oleg.my_labs.Collection;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumnerStorageStructureTest {

    @Test
    void shouldResultAddElement() {
        //given
        MyCollection myCollection=new MyCollection ();
        myCollection.add (23);
        myCollection.add (18);
        myCollection.add (45);
        myCollection.add (6);
        myCollection.add (54);
        myCollection.add (43);

        TreeSet<Integer> treeSet=new TreeSet<> ();
        treeSet.add (23);
        treeSet.add (18);
        treeSet.add (45);
        treeSet.add (6);
        treeSet.add (54);
        treeSet.add (43);
        treeSet.add (87);



        //when
        boolean result=myCollection.add (87);


        //then
        assertThat(result).isTrue();
        assertEquals(myCollection,treeSet);
    }

}