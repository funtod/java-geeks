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

}