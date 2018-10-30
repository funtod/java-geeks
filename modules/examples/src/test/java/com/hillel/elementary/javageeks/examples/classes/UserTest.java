package com.hillel.elementary.javageeks.examples.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @Test
    void shouldCall() {

        User[] users = {
                new User("Vasya", 1L),
                new User("Petya", 2L),
                new SuperUser("Petya", 2L, "PP"),

        };

//        UserService.callEveryone(users);
        SuperUser user = new SuperUser("Petya", 2L, "PP");
        System.out.println(user.getName());
        System.out.println(user.getLastName());
    }
}