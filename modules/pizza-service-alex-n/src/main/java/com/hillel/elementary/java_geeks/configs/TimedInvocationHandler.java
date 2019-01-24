package com.hillel.elementary.java_geeks.configs;

import com.hillel.elementary.java_geeks.configs.anotations.Timed;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimedInvocationHandler implements InvocationHandler {

    private Object target;

    TimedInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method realMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
        Timed annotation = realMethod.getAnnotation(Timed.class);
        if (annotation != null && annotation.isOn()) {
            long nanos = System.nanoTime();
            try {
                return realMethod.invoke(target, args);
            } finally {
                nanos = System.nanoTime() - nanos;
                System.out.printf("Method: %s complete in: %d%n ns", method.getName(), nanos);
            }
        }
        return realMethod.invoke(target, args);
    }
}
