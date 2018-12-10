package com.hillel.elementary.javageeks.dir.homework5.fraction;

import java.util.Iterator;
import java.util.List;

public class Fractions {
    protected Fractions() {
    }

    public static List modifyFractions(List<Fraction> list) throws Exception {
        List<Fraction> modifiedList = list.getClass().newInstance();
        for (Fraction fraction:list) {
            modifiedList.add(new Fraction(fraction));
        }

        Iterator<Fraction> iterator = modifiedList.iterator();
        int currIndex = 0;
        while (iterator.hasNext()) {
            Fraction currFraction = iterator.next();
            if (currIndex > 0 && (currIndex) % 2 == 0 && iterator.hasNext()) {
                Fraction nextFraction = iterator.next();
                currIndex++;
                currFraction.addValues(nextFraction);
            }
            currIndex++;
        }
        return modifiedList;
    }
}
