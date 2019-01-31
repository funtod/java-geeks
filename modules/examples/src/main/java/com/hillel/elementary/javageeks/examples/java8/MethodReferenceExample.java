package com.hillel.elementary.javageeks.examples.java8;

public class MethodReferenceExample {
    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }
}

class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}