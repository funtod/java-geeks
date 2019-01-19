package com.hillel.elementary.javageeks.dir.pizza_service.profiling;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Timed;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

public class Profiler {
    public static <T> T getProfiler(T obj) {
        Class<?> cl = obj.getClass();
        Class<?>[] interfaces = cl.getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Timed annotation = method.getAnnotation(Timed.class);
                boolean isTimed = annotation != null;
                long timeMillBefore = 0;
                long timeMillAfter;
                if (isTimed) {
                    timeMillBefore = new Date().getTime();
                }
                Object result = method.invoke(obj, args);
                if (isTimed) {
                    timeMillAfter = new Date().getTime();
                    System.out.println(timeMillAfter - timeMillBefore);
                }
                return result;
            }
        };
        Object proxy = Proxy.newProxyInstance(Profiler.class.getClassLoader(), interfaces, handler);
        return (T) proxy;
    }
}
