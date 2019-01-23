package com.hillel.elementary.javageeks.dir.pizza_service.profiling;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Timed;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Profiler {
  private Profiler() {
  }

  public static <T> T wrap(T obj) {
        Logger logger = LoggerFactory.getLogger(Profiler.class);
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
                Method realMethod = cl.getMethod(method.getName(), method.getParameterTypes());
                Object result = realMethod.invoke(obj, args);
                if (isTimed) {
                    long nanosAfter = System.nanoTime();
                    logger.debug(String.format("%s.%s() time elapsed in nanos: %d%n", cl.getSimpleName(),
                            method.getName(), nanosAfter - nanosBefore));
                }
                return result;
            }
        };
        Object proxy = Proxy.newProxyInstance(Profiler.class.getClassLoader(), interfaces, handler);
        return (T) proxy;
    }
}
