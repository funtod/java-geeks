package com.hillel.elementary.javageeks.examples.classes;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableUserTest {

    @Test
    void shouldBeImmutable() {

        Date date = new Date();
        ImmutableUser user = new ImmutableUser("Petya", date);
        date.setYear(1990);

        System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(user.getBirthDate()));
    }
}