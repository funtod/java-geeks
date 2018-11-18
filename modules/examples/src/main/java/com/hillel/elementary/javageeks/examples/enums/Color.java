package com.hillel.elementary.javageeks.examples.enums;

import java.util.Comparator;

public enum Color implements Comparator<Color> {
    RED("FFd6"),
    GREEN("FF5fh"),
    BLUE("BF463");

    public String hex;

    Color(String hex) {
        this.hex = hex;
    }

    @Override
    public int compare(Color o1, Color o2) {
        return o1.hex.compareTo(o2.hex);
    }


}
