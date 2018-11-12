package com.hillel.elementary.javageeks.oleg.my_labs.Regular_expressions;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RegularExpressionsTest {

    @Test
   public void shouldResultFindMinLength(){
        //given
        String str ="Hello my friend! I am here. O";

        //when
        String result=RegularExpressions.findMinLength (str);

        //then
        assertThat (result).isEqualToIgnoringCase ("I O");
   }


    @Test
    public void shouldResultFindMaxLength(){
    //given
    String str ="Hello my friend! I am here";

    //when
    String result=RegularExpressions.findMaxLength (str);

    //then
    assertThat (result).isEqualToIgnoringCase ("friend");
    }
}