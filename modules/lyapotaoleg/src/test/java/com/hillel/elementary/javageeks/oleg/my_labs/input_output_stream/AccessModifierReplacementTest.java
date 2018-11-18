package com.hillel.elementary.javageeks.oleg.my_labs.input_output_stream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

class AccessModifierReplacementTest {

    @Test
    public void shouldResultReadFromFile(){
        //given
        URL resource =AccessModifierReplacementTest.class.getClassLoader ().getResource ("TextForCopy.txt");
        String fileFrom=resource.getFile ();


        //when
        String result="public class BinarySearch {\\n\\n" +
                "    public static int find(int numberToFind, int[] array) {\\n" +
                "        if (array == null || array.length == 0) return -1;\\n\\n" +
                "        int index = array.length / 2;\\n" +
                "        int oldIndex;\\n\\n" +
                "        while (true) {\\n" +
                "            int currentElement = array[index];\\n" +
                "            oldIndex = index;\\n" +
                "            if (currentElement == numberToFind) {\\n" +
                "                return index;\\n" +
                "            } else if (currentElement < numberToFind) {\\n" +
                "                index = index/2 + index;\\n" +
                "            } else {\\n" +
                "                index = index/2;\\n" +
                "            }\\n" +
                "            if (oldIndex == index) break;\\n" +
                "        }\\n\\n" +
                "        return -1;\\n" +
                "    }\\n";
        //then
        assertThat(result).isEqualTo (AccessModifierReplacement.readFromFile (fileFrom));

    }

    @Test
    public void shouldResultConvert(){
        //given
        String str="public static void main\\n"+
                "public String revert";

        //when
        String result="private static void main\\n"+
                "private String revert";

        //then
        assertThat (result).isEqualTo (AccessModifierReplacement.convert (str));
    }




}