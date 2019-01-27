package com.hillel.elementary.javageeks.dir.pizza_service.proxifying;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Timed;
import com.hillel.elementary.javageeks.dir.pizza_service.utility.Logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class ProxyClass {

  private ProxyClass() {
  }

  public static <T> T wrap(T obj) {
        Class<?> cl = obj.getClass();
        Class<?>[] interfaces = cl.getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Method realMethod = cl.getMethod(method.getName(), method.getParameterTypes());
                Timed annotation = realMethod.getAnnotation(Timed.class);
                boolean isTimed = annotation != null;
                long nanosBefore = 0;
                if (isTimed) {
                    nanosBefore = System.nanoTime();
                }
                Object result = realMethod.invoke(obj, args);
                if (isTimed) {
                    long nanosAfter = System.nanoTime();
                    Logging.LOGGER.debug(String.format("%s.%s() time elapsed in nanos: %d%n", cl.getSimpleName(),
                            method.getName(), nanosAfter - nanosBefore));
                }
                return result;
            }
        };
        Object proxy = Proxy.newProxyInstance(ProxyClass.class.getClassLoader(), interfaces, handler);
        return (T) proxy;
    }
}
