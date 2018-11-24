package com.hillel.elementary.javageeks.ruslanTask5;

import java.util.Arrays;

public class Reg1 {

    public static void main(String[] args) {
        Regexp reg = new Regexp();


        String str = "I honour your circumspection. A fortnight's acquaintance is certainly\n"
                + "very little. One cannot know what a man really is by the end of a\n"
                + "fortnight. But if we do not venture somebody else will; and after all,\n"
                + "Mrs. Long and her neices must stand their chance; and, therefore, as\n"
                + "she will think it an act of kindness, if you decline the office, I will\n"
                + "take it on myself.";

      //  String str1 = "I honour your circumspection. A fortnight's acquaintance is certainly blah...";
       String[] arr = reg.returnUniqArrayDevide(str);
        System.out.println(Arrays.toString(arr));
    }
}
