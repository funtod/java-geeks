package com.hillel.elementary.javageeks.oleg.my_labs.lab_4;

public class TextPrinter {
    public static void print(String text)throws MyExeption{
        TextConvert.convert (text);
    }

    public static void main(String[] args) {
        try {
            System.out.println ();

            print ("Hello my friend");
            System.out.println ();
            print ("Hello");
        } catch (MyExeption exeption) {
            System.out.println ("exception caught " + exeption);
        }
    }

}
