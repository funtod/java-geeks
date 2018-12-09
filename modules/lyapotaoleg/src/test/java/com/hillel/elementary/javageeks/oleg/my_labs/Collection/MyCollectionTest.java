package com.hillel.elementary.javageeks.oleg.my_labs.Collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MyCollectionTest {

    @Test
    void shouldResultAddElement() {
        MyCollection myCollection=new MyCollection ();
        myCollection.addElement (23);
//        myCollection.addElement (18);
//        myCollection.addElement (45);
//        myCollection.addElement (6);
//        myCollection.addElement (54);
//        myCollection.addElement (43);

        MyCollection myCollectionother=new MyCollection ();
        myCollectionother.addElement (23);
//        myCollectionother.addElement (18);
//        myCollectionother.addElement (45);
//        myCollectionother.addElement (6);
//        myCollectionother.addElement (54);
//        myCollectionother.addElement (43);
        myCollectionother.addElement (87);



        //when
        boolean result=myCollection.addElement (87);


        //then
        assertThat(result).isTrue();
//        assertEquals(myCollection,myCollectionother);
    }

//    @Test
//    void shouldResultDeleteElement(){
//        ArrayList<Integer> arrayList=new ArrayList<> ();
//        arrayList.add (43);
//        arrayList.add (18);
//        arrayList.add (45);
//        arrayList.add (6);
//        arrayList.add (54);
//        arrayList.add (43);
//
//        ArrayList<Integer> arrayListOther=new ArrayList<> ();
//        arrayListOther.add (23);
//        arrayListOther.add (18);
//        arrayListOther.add (45);
//        arrayListOther.add (6);
//        arrayListOther.add (54);
//
//        //when
////        boolean result = arrayList.remove(43);
//
//        //then
////        assertThat (result).isTrue ();
////        assertEquals (arrayList,arrayListOther);
//    }
//
//    void shouldResultFindElement(){
//        //given
//        ArrayList<Integer> arrayList=new ArrayList<> ();
//        arrayList.add (23);
//        arrayList.add (18);
//        arrayList.add (45);
//        arrayList.add (6);
//        arrayList.add (54);
//        arrayList.add (43);
//
//        Integer numbers=41;
//
//        //when
//        Integer result=43;
//
////        assertThat (arrayList.findElement(numbers).isEquals(result));
//
//    }


}