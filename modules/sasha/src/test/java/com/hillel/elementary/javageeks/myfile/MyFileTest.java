package com.hillel.elementary.javageeks.myfile;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class MyFileTest {
    @Test
    void shouldParseFile(){

        URL resource = MyFileTest.class.getClassLoader().getResource("test.txt");
        String fileFrom = resource.getFile();

        Integer[] nums = {2, 4};

        assertArrayEquals(nums,MyFile.parseFile(fileFrom,"fas gd css").toArray());
    }

}