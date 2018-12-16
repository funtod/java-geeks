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
        NumnerStorageStructure numnerStorageStructure=new NumnerStorageStructure (treeSet);
        numnerStorageStructure.addElement (12);
        numnerStorageStructure.addElement (18);
        numnerStorageStructure.addElement (23);
        numnerStorageStructure.addElement (5);
        numnerStorageStructure.addElement (11);

        TreeSet<Integer>treeSetResult=new TreeSet<> ();
        NumnerStorageStructure numnerStorageStructure1=new NumnerStorageStructure (treeSetResult);
        numnerStorageStructure1.addElement (12);
        numnerStorageStructure1.addElement (18);
        numnerStorageStructure1.addElement (23);
        numnerStorageStructure1.addElement (5);
        numnerStorageStructure1.addElement (11);
        numnerStorageStructure1.addElement (99);

        //when
        boolean result=numnerStorageStructure.addElement (99);

        //then
        assertThat(result).isTrue();
        assertEquals(treeSet,treeSetResult);
    }

    @Test
    void shouldResultDeleteElement() {

        //given
        TreeSet<Integer> treeSet=new TreeSet<> ();
        NumnerStorageStructure numnerStorageStructure=new NumnerStorageStructure (treeSet);
        numnerStorageStructure.addElement (12);
        numnerStorageStructure.addElement (18);
        numnerStorageStructure.addElement (23);
        numnerStorageStructure.addElement (5);
        numnerStorageStructure.addElement (11);

        TreeSet<Integer>treeSetResult=new TreeSet<> ();
        NumnerStorageStructure numnerStorageStructure1=new NumnerStorageStructure (treeSetResult);
        numnerStorageStructure1.addElement (12);
        numnerStorageStructure1.addElement (18);
        numnerStorageStructure1.addElement (23);
        numnerStorageStructure1.addElement (5);


//        when
        boolean result=numnerStorageStructure.deleteElement (11);

        //then
        assertThat(result).isTrue();
        assertEquals(treeSetResult,treeSet);
    }

    @Test
    void shouldResultFindElement() {
        //given
        TreeSet<Integer> treeSet=new TreeSet<> ();
        NumnerStorageStructure numnerStorageStructure=new NumnerStorageStructure (treeSet);
        numnerStorageStructure.addElement (12);
        numnerStorageStructure.addElement (18);
        numnerStorageStructure.addElement (23);
        numnerStorageStructure.addElement (5);
        numnerStorageStructure.addElement (11);

        //when
        Integer result=11;

        //then
        assertThat (numnerStorageStructure.findElement (9)).isEqualTo (result);


    }

}