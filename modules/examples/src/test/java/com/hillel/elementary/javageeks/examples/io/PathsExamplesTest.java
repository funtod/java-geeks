package com.hillel.elementary.javageeks.examples.io;

import org.junit.jupiter.api.Test;


class PathsExamplesTest {

    @Test
    void shouldSearchForFiles() {
        PathsExamples.search(System.getProperty("user.dir"), "pride_and_prejudice.txt");
    }
}