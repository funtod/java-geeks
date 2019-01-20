package com.hillel.elementary.javageeks.dir.pizza_service.profiling;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Timed;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Profiler {
    public static <T> T getProfiler(T obj) {
        Class<?> cl = obj.getClass();
        Class<?>[] interfaces = cl.getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Timed annotation = method.getAnnotation(Timed.class);
                boolean isTimed = annotation != null;
                long nanosBefore = 0;
                if (isTimed) {
                    nanosBefore = System.nanoTime();
                }
                Object result = method.invoke(obj, args);
                if (isTimed) {
                    long nanosAfter = System.nanoTime();
                    System.out.printf("%s.%s() time elapsed in nanos: %d%n", cl.getSimpleName(), method.getName(), nanosAfter - nanosBefore);
                }
                return result;
            }
        };
        Object proxy = Proxy.newProxyInstance(Profiler.class.getClassLoader(), interfaces, handler);
        return (T) proxy;
    }
}
