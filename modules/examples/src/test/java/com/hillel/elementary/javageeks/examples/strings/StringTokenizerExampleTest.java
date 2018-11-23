package com.hillel.elementary.javageeks.examples.strings;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class StringTokenizerExampleTest {

    @Test
    void shouldParceProducts() {
        Product[] expectedResult = {
                new Product(1, 2.0, "Vanya"),
                new Product(2, 2.1, "Jack"),
                new Product(3, 0.2, "Tamil"),
                new Product(4, 2.5, "Leeroy"),
        };
        String text = "1|2.0|Vanya\n" +
                "2|2.1|Jack\n" +
                "3|0.2|Tamil\n" +
                "4|2.5|Leeroy";

        Product[] products = StringTokenizerExample.parseProducts(text);

        assertThat(products).isEqualTo(expectedResult);
    }
}
