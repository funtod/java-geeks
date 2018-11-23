package com.hillel.elementary.javageeks.text_formatter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class TextFormatterTest {

    TextFormatter textFormatter = new TextFormatter();

    @Test
    void shouldReformatString() {
        String givenStr = "word1 word2\nword3 word4\nword5 word6.";
        String expectStr = "word1 word2 word3\nword4 word5 word6.";
        assertThat(textFormatter.reformatLineFeedsByMaxWidth(givenStr, 18)).isEqualTo(expectStr);
    }

    @Test
    void shouldReformatStringWithSigns() {
        String givenStr = "word1, word2>\nword3. word4!\nword5$ word6.";
        String expectStr = "word1, word2> word3.\nword4! word5$ word6.";
        assertThat(textFormatter.reformatLineFeedsByMaxWidth(givenStr, 21)).isEqualTo(expectStr);
    }

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

    @Test
    void shouldAlignTextWithSymbolsAndDoNotLoseAnything() {
        String givenStr = "word1, word2>\nword3. word4!\nword5$ word6.";
        assertThat(textFormatter.textAlignCenter(givenStr, 20)).contains("word5$", "word2>", "word3.", "word4!", "word5$", "word6.");
    }

    @Test
    void shouldDealWithAligningEmptyString() {
        String str = "";
        assertThat(textFormatter.textAlignCenter(str,10)).isEqualTo(str);
    }

    @Test
    void shouldDealWithReformattingEmptyString() {
        String str = "";
        assertThat(textFormatter.reformatLineFeedsByMaxWidth(str,10)).isEqualTo(str);
    }

    @Test
    void shouldDealWithAligningNull() {
        String str = null;
        assertThat(textFormatter.textAlignCenter(str,10)).isNull();
    }

    @Test
    void shouldDealWithReformattingNull() {
        String str = null;
        assertThat(textFormatter.reformatLineFeedsByMaxWidth(str,10)).isNull();
    }

    @Test
    void shouldReformatOneSymbolString() {
        String str = "a";
        assertThat(textFormatter.reformatLineFeedsByMaxWidth(str,10)).isEqualTo("a");
    }

    @Test
    void shouldAlignOneSymbolString() {
        String str = "a";
        assertThat(textFormatter.textAlignCenter(str,1)).isEqualTo("a");
    }
}