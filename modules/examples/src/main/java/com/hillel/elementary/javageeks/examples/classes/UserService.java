package com.hillel.elementary.javageeks.examples.classes;

public class UserService {

    public static void callEveryone(User[] users) {
        for (int i = 0; i < users.length; i++) {
            users[i].callCall();
        }
    }
}
