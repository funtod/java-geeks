package com.hillel.elementary.javageeks.examples.classes;

public class Initializers {

    static int staticNumber = -1;
    int number = -2;

    static {
        staticNumber = -3;
    }

    {
        number = -4;
    }

    public Initializers() {
        number = -5;
    }

}


class InitializersChild extends Initializers{

    {
        number = 4;
    }

    static {
        staticNumber = 3;
    }

    public InitializersChild() {
        number = 5;
    }
}
