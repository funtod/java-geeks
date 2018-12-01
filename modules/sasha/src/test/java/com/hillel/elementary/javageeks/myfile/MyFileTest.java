package com.hillel.elementary.javageeks.myfile;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MyFileTest {
    @Test
    void shouldParseFile(){



        String[] str = new String[2];
        str[0] = "test.txt";
        str[1] = "fas gd css";

        Integer[] nums = {2, 4};


        assertArrayEquals(nums,MyFile.parseFile(str).toArray());
    }

}