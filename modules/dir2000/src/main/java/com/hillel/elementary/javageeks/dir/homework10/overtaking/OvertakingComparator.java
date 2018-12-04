package com.hillel.elementary.javageeks.dir.homework10.overtaking;

import java.util.Comparator;

class OvertakingComparator implements Comparator<Overtaking> {
    @Override
    public int compare(Overtaking oOne, Overtaking oTwo) {
        return Double.compare(oOne.getTime(), oTwo.getTime());
    }
}
