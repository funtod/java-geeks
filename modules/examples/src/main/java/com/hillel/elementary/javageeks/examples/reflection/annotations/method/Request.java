package com.hillel.elementary.javageeks.examples.reflection.annotations.method;

import java.lang.reflect.Method;

public class Request {

    @RequestForCustomer(level = 2, description = "Enabletime", date = "10/10/2007")
    public void customerThroughTime() {
        try {
            Class aClass = this.getClass();
            Method m = aClass.getMethod("customerThroughTime");
            RequestForCustomer annotation = m.getAnnotation(RequestForCustomer.class);
            System.out.println(annotation.level() + " " + annotation.description() + " " + annotation.date());
        } catch (NoSuchMethodException e) {
            System.out.println("метод не найден");
        }
    }

    public static void main(String[] args) {
        Request request = new Request();

        request.customerThroughTime();
    }
}
