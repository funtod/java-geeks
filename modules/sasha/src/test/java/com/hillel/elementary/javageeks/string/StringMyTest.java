package com.hillel.elementary.javageeks.string;

import org.junit.jupiter.api.Test;



class StringMyTest {
    @Test
    public void shouldStringMyAddedSimbol(){
        StringMy stringMy = new StringMy();

        assertArrayEquals("axwwww dfaxwwww",
                stringMy.addWord("ax dfax","wwww"));
    }

    private void assertArrayEquals(String axwww_dfaxwwww, StringBuilder ax_dfax) {
    }

}