package com.hillel.elementary.javageeks.task6;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReplacerTest {

    @Test
    void shouldReplace() throws IOException {
        String replacedText = Replacer.replace("/TestJavaClass.java");
        System.out.println(replacedText);
        assertEquals("\n" +
                "package com.hillel.elementary.javageeks.task3;\n" +
                "\n" +
                "private class Ocean {\n" +
                "    private String name;\n" +
                "\n" +
                "    private Ocean(String name) {\n" +
                "        this.name = name;\n" +
                "    }\n" +
                "\n" +
                "    private String getName(){\n" +
                "        return name;\n" +
                "    }\n" +
                "}" +
                "\n",replacedText);    }
}