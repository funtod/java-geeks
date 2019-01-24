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

                Class[] interfaces = bean.getClass().getInterfaces();
                ClassLoader classLoader = bean.getClass().getClassLoader();

                return Proxy.newProxyInstance(classLoader, interfaces, new TimedInvocationHandler(bean));
            }
        }
        return bean;
    }
}
