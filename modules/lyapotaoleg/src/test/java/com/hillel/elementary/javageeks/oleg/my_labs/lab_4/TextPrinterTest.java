package com.hillel.elementary.javageeks.oleg.my_labs.lab_4;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TextPrinterTest {
    @Test
    public void shouldResultMethodConvert() throws MyExeption{
        String text="Hello my friend";

        String result="Hello my friend";


        assertThat(result).isEqualTo (TextConvert.convert(text));



    }

    @Test
    void shouldThrowExceptionIfLengthMoreThanExpected() {
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable () {
            @Override
            public void call() throws Throwable {
                TextConvert.convert ("a");
            }
        }).isInstanceOf (MyExeption.class);
    }
}