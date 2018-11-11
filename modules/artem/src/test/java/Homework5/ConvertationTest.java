package Homework5;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class ConvertationTest {

    @Test
    public void shouldReturnNanIfException(){
    Convertation convertation = new Convertation();
    String str = convertation.convertation(5);
    assertThat(str).isEqualTo("5.0");
    }
}