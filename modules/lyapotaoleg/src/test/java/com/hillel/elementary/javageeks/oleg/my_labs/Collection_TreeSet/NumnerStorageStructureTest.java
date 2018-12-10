package com.hillel.elementary.javageeks.oleg.my_labs.Collection_TreeSet;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumnerStorageStructureTest {

    @Test
    void shouldResultAddElement() {
        //given
        TreeSet<Integer> treeSet=new TreeSet<> ();
        NumnerStorageStructure numnerStorageStructure=new NumnerStorageStructure ();
        numnerStorageStructure.addElement (treeSet,12);
        numnerStorageStructure.addElement (treeSet,18);
        numnerStorageStructure.addElement (treeSet,23);
        numnerStorageStructure.addElement (treeSet,5);
        numnerStorageStructure.addElement (treeSet,11);

        TreeSet<Integer>treeSetResult=new TreeSet<> ();
        NumnerStorageStructure numnerStorageStructure1=new NumnerStorageStructure ();
        numnerStorageStructure1.addElement (treeSetResult,12);
        numnerStorageStructure1.addElement (treeSetResult,18);
        numnerStorageStructure1.addElement (treeSetResult,23);
        numnerStorageStructure1.addElement (treeSetResult,5);
        numnerStorageStructure1.addElement (treeSetResult,11);
        numnerStorageStructure1.addElement (treeSetResult,99);

        //when
        boolean result=numnerStorageStructure.addElement (treeSet,99);

        //then
        assertThat(result).isTrue();
        assertEquals(treeSetResult,treeSet);
    }

    @Test
    void shouldResultDeleteElement() {

        //given
        TreeSet<Integer> treeSet=new TreeSet<> ();
        NumnerStorageStructure numnerStorageStructure=new NumnerStorageStructure ();
        numnerStorageStructure.addElement (treeSet,12);
        numnerStorageStructure.addElement (treeSet,18);
        numnerStorageStructure.addElement (treeSet,23);
        numnerStorageStructure.addElement (treeSet,5);
        numnerStorageStructure.addElement (treeSet,11);

        TreeSet<Integer>treeSetResult=new TreeSet<> ();
        NumnerStorageStructure numnerStorageStructure1=new NumnerStorageStructure ();
        numnerStorageStructure1.addElement (treeSetResult,12);
        numnerStorageStructure1.addElement (treeSetResult,18);
        numnerStorageStructure1.addElement (treeSetResult,23);
        numnerStorageStructure1.addElement (treeSetResult,5);


//        when
        boolean result=numnerStorageStructure.deleteElement (treeSet,11);

        //then
        assertThat(result).isTrue();
        assertEquals(treeSetResult,treeSet);
    }

    @Test
    void shouldResultFindElement() {
        //given
        TreeSet<Integer> treeSet=new TreeSet<> ();
        NumnerStorageStructure numnerStorageStructure=new NumnerStorageStructure ();
        numnerStorageStructure.addElement (treeSet,12);
        numnerStorageStructure.addElement (treeSet,18);
        numnerStorageStructure.addElement (treeSet,23);
        numnerStorageStructure.addElement (treeSet,5);
        numnerStorageStructure.addElement (treeSet,11);

        //when
        Integer result=11;

        //then
        assertThat (numnerStorageStructure.findElement (treeSet,9)).isEqualTo (result);


    }

}