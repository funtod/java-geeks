package com.hillel.elementary.java_geeks.configs;

import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.configs.anotations.PostCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DefaultPizzaServiceContext implements Context {

    private static final Logger logger = LoggerFactory.getLogger(DefaultPizzaServiceContext.class);
    private final Config config;
    private Map<String, Object> beans = new HashMap<>();

    public DefaultPizzaServiceContext(Config config) {
        this.config = config;
    }

    @Override
    public <T> T getBean(String beanName) throws Exception {
        if (beanName == null || beanName.isEmpty()) {
            throw new IllegalArgumentException("Bean name must be not null and not empty");
        }
        if (beans.containsKey(beanName)) {
            return (T) beans.get(beanName);
        }

        Class<?> beanClass = config.getBeanClassByName(beanName);
        Constructor<?> constructor = beanClass.getConstructors()[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] constructorArguments = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> clazz = parameterTypes[i];
            if (clazz.isInterface()) {
                clazz = config.getBeanClassByInterface(clazz);
            }

            Component componentAnnotation = clazz.getAnnotation(Component.class);
            if (componentAnnotation == null) {
                String msg = String.format("There is argument in %s which we can not create bean for", beanName);
                throw new IllegalArgumentException(msg);
            }
            String constructorArgumentBeanName = componentAnnotation.value();
            if (beans.containsKey(constructorArgumentBeanName)) {
                constructorArguments[i] = beans.get(constructorArgumentBeanName);
            } else {
                constructorArguments[i] = getBean(constructorArgumentBeanName);
            }
        }

        Object bean = constructor.newInstance(constructorArguments);
        bean = ProxyCreator.getProxyForBean(bean);
        invokeAnnotatedMethods(bean);
        beans.put(beanName, bean);

        return (T) bean;
    }

    private void invokeAnnotatedMethods(Object bean) {
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(PostCreate.class)) {
                if (method.getParameterCount() != 0) {
                    throw new IllegalArgumentException("Method annotated with @PostCreate, can't has parameters");
                } else {
                    try {
                        method.setAccessible(true);
                        method.invoke(bean);
                        logger.info("Invoke method: " + method.getName() + " which annotated with @PostCreate");
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
