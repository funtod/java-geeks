package com.hillel.elementary.java_geeks.configs;

import com.hillel.elementary.java_geeks.configs.anotations.Timed;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class ProxyCreator {

    private ProxyCreator() {
    }

    static Object getProxyForBean(Object bean) {
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Timed.class)) {

                ClassLoader classLoader = bean.getClass().getClassLoader();
                Class[] interfaces = bean.getClass().getInterfaces();
                /*in case we will have a class that extends abstract class that implements interface
                Just like: JsonPizzaRepo -> AbstractPizzaRepo -> PizzaRepo */
                if (interfaces.length == 0) {
                    interfaces = bean.getClass().getSuperclass().getInterfaces();
                }

                return Proxy.newProxyInstance(classLoader, interfaces, new TimedInvocationHandler(bean));
            }
        }
        return bean;
    }
}
