package com.hillel.elementary.javageeks.examples.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsersSorter {

    public void sortWithAbstractClass(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });
    }

    public void sortWithLambda(List<User> users) {
        users.sort((o1, o2) -> o1.getAge() - o2.getAge());
    }

    public void sortWithLambdaMultipleFields(List<User> users) {
        users.sort((o1, o2) -> {
            if (o1.getAge() == o2.getAge())
                return o1.getName().compareTo(o2.getName());
            else return o1.getAge() - o2.getAge();
        });
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
