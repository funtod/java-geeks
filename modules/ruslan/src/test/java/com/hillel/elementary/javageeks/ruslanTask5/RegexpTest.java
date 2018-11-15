package com.hillel.elementary.javageeks.ruslanTask5;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
class RegexpTest {
    @Test
    public void shouldFindWorld(){
        //given
        String text = "I would like to find Ruslan Ruslan";
        //when
        String result=Regexp.findWorld("Ruslan")
        //then

    }

