package com.hillel.elementary.javageeks.examples.tests;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElementFinderTest {

    @Test
    void shouldReturnNullIfNotFound() {
        //given
        Long id = 0L;
        Container[] containers = new Container[0];

        //when
        Container result = ElementFinder.findById(id, containers);

        //then
        assertThat(result).isNull();
    }

    @Test
    void shouldReturnContainerById() {
        //given
        Long id = 1L;
        Container container = new Container(1L);
        Container[] containers = {
                container,
                new Container(2L),
                new Container(25L),
        };

        //when
        Container result = ElementFinder.findById(id, containers);

        //then
        assertThat(result).isEqualTo(container);
    }

    @Test
    void shouldReturnNullIfIdIsNull() {
        //given
        Container[] containers = {};

        //when
        Container result = ElementFinder.findById(null, containers);

        //then
        assertThat(result).isNull();
    }

    @Test
    void shouldReturnNullIfIdIsNullAndContainersIdIsNull() {
        //given
        Container[] containers = {
                new Container(null)
        };

        //when
        Container result = ElementFinder.findById(null, containers);

        //then
        assertThat(result).isNull();
    }

    @Test
    void shouldReturnNullContainersIsNull() {
        //when
        Container result = ElementFinder.findById(1L, null);

        //then
        assertThat(result).isNull();
    }

    @Test
    void shouldIgnoreContainersWhichAreull() {
        //given
        Container container = new Container(1L);
        Container[] containers = {
                null,
                container,

        };

        //when
        Container result = ElementFinder.findById(1L, containers);

        //then
        assertThat(result).isEqualTo(container);
    }


    @Test
    void shouldReturnTrueIfElementIsInArray() {
        //given
        Container container = new Container(1L, "label", new InnerContainer("name"));
        Container[] containers = {
                null,
                new Container(1L, "label", new InnerContainer("name")),
        };

        //when
        boolean result = ElementFinder.contains(container, containers);

        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldReturnFalseIfElementIsNotInArray() {
        //given
        Container container = new Container(2L, "label", new InnerContainer("name"));
        Container[] containers = {
                null,
                new Container(1L, "label", new InnerContainer("name")),
        };

        //when
        boolean result = ElementFinder.contains(container, containers);

        //then
        assertThat(result).isFalse();
    }
}