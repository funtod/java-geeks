package com.hillel.elementary.javageeks.ruslanTask7;

import java.util.ArrayList;
import java.util.Collections;

public class SortArray {

    public ArrayList<Integer> getArray( ArrayList<Integer> arrayList){

       Collections.sort(arrayList, Collections.reverseOrder());

        return arrayList;
    }
}
