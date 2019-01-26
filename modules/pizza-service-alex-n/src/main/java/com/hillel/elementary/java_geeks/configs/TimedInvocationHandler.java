package com.hillel.elementary.java_geeks.configs;

import com.hillel.elementary.java_geeks.configs.anotations.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimedInvocationHandler implements InvocationHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimedInvocationHandler.class);
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
                LOGGER.info(String.format("Method: %s completed in: %d ns", method.getName(), nanos));
            }
        }
        return realMethod.invoke(target, args);
    }
}
