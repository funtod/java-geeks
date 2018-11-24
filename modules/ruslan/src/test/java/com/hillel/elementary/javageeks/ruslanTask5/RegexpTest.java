package com.hillel.elementary.javageeks.ruslanTask5;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RegexpTest {

    @Test
    public void shouldReadNumberFromOnetoSeven () {

        //given
        String str = "When groups are nested inside each other, they Are numbered based are fdsfsdf dsf f4 dsf2 3 f are";
        Regexp reg = new Regexp ();
        String [] ar = reg.returnUniqArrayDevide(str);

        //then
        assertThat(ar.length).isEqualTo(3);
        assertThat(ar[0]).isEqualTo("are:4");
    }

    @Test
    public void shouldCalculateUniqueWordsFromText() {
        //given
        String str = "I honour your circumspection. A fortnight's acquaintance is certainly\n"
                + "very little. One cannot know what a man really is by the end of a\n"
                + "fortnight. But if we do not venture somebody else will; and after all,\n"
                + "Mrs. Long and her neices must stand their chance; and, therefore, as\n"
                + "she will think it an act of kindness, if you decline the office, I will\n"
                + "take it on myself.";
        Regexp reg = new Regexp();
        String[] ar = reg.returnUniqArrayDevide(str);
        //then
//        assertThat(findWordOccurrences("is", ar)).isEqualTo(2);
//        assertThat(findWordOccurrences("I", ar)).isEqualTo(2);
//        assertThat(findWordOccurrences("if", ar)).isEqualTo(2);
//        assertThat(findWordOccurrences("by", ar)).isEqualTo(2);
        assertThat(findWordOccurrences("the", ar)).isEqualTo(2);
          assertThat(findWordOccurrences("of", ar)).isEqualTo(2);
           assertThat(findWordOccurrences("it", ar)).isEqualTo(2);
           assertThat(findWordOccurrences("a", ar)).isEqualTo(-1);
           assertThat(findWordOccurrences("chance", ar)).isEqualTo(-1);
        assertThat(findWordOccurrences("will", ar)).isEqualTo(-1);
    }

    @Test
    public void shouldReturnEmptyArrayIfOnlyOddOccurrencesInText() {
        //given
        String str = "I honour your circumspection. A fortnight's acquaintance is certainly blah...";
        Regexp reg = new Regexp();
        String[] ar = reg.returnUniqArrayDevide(str);
        //then
        assertThat(ar.length).isEqualTo(0);
    }
    private int findWordOccurrences(String word, String[] array) {
        for (String pair : array) {
            if (pair.startsWith(word + ":")) {
                return Integer.parseInt(pair.substring(pair.indexOf(":") + 1));
            }
        }
        return -1;
    }

}