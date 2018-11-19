package com.hillel.elementary.javageeks.examples.classes.nested_interface;

public class Watercraft {

    interface Swimmable {
        void swim();
    }

    static class Boat implements Swimmable {

        @Override
        public void swim() {

        }
    }

    static class Ship implements Swimmable {

        @Override
        public void swim() {

        }
    }

    static class Submarine implements Swimmable {

        @Override
        public void swim() {

        }
    }
}
