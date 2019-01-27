package com.hillel.elementary.javageeks.dir.pizza_service.context;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.PostCreate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class BeanAnnotationProcessing {
    static void processPostCreate(Class<?> beanClass, Object bean) throws IllegalAccessException, InvocationTargetException {
        for (Method beanClassMethod : beanClass.getDeclaredMethods()) {
            if (beanClassMethod.isAnnotationPresent(PostCreate.class)) {
                if (beanClassMethod.getParameterCount() != 0) {
                    throw new IllegalStateException("The method " + beanClassMethod
                            + ", annotated by @PostCreate, should have no parameters.");
                }
                beanClassMethod.setAccessible(true);
                beanClassMethod.invoke(bean);
            }
        }
    }
}
