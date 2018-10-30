package com.hillel.elementary.javageeks.examples.classes.local_class;

public class LocalClass {

    public static void doSmth(int sum) {

        class Inner {
            public int divisor;
            public int remainder;

            public Inner() {
                divisor = 4;
                remainder = sum % divisor;
            }

            private int getDivisor() {
                return divisor;
            }

            private int getRemainder() {
                return sum % divisor;
            }

            private int getQuotient() {
                return sum / divisor;
            }
        }

        Inner inner = new Inner();
        System.out.println("Divisor = "+ inner.getDivisor());
        System.out.println("Remainder = " + inner.getRemainder());
        System.out.println("Quotient = " + inner.getQuotient());
    }
}
