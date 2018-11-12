package com.hillel.elementary.javageeks.text_formatter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class TextFormatterTest {

    TextFormatter textFormatter = new TextFormatter();

    @Test
    void shouldReformatStringByMaxWidth() {
        String str = "word1\nword2\nword3\nword4";
        assertThat(textFormatter.reformatLineFeedsByMaxWidth(str, 12).split("\n").length).isEqualTo(2);
    }

    @Test
    void shouldAlignCenterByMaxWidth() {
        String str = "aaa bbb ccc ddd\naaa bbb ccc\naaa bbb\naaa";
        assertThat(textFormatter.textAlignCenter(str, 16).split("\n")[2].length()).isEqualTo(16);
    }
}