package com.hillel.elementary.javageeks.dir.pizza_service.context;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SimpleImplementationContext implements Context {
  private final Config config;
  private final Map<String, Object> beans = new HashMap<>();

  public SimpleImplementationContext(Config argConfig) {
    config = argConfig;
  }

  @Override
  public <T> T getBean(String beanName) {
    if (beanName == null) {
      throw new IllegalArgumentException("Bean should have not null name.");
    }
    if (beans.containsKey(beanName)) {
      return (T) beans.get(beanName);
    }

    Class<?> beanClass = config.getClassByBeanName(beanName);
    Constructor<?> constructor = beanClass.getConstructors()[0];
    Class<?>[] parameterTypes = constructor.getParameterTypes();
    Object[] constructorArgs = new Object[parameterTypes.length];
    for (int i = 0; i < parameterTypes.length; i++) {
      Class<?> classOfparameter = parameterTypes[i];
      if (classOfparameter.isInterface()) {
        classOfparameter = config.getBeanClassByInterface(classOfparameter);
      }
      Component annotation = classOfparameter.getAnnotation(Component.class);
      if (annotation == null) {
        throw new IllegalStateException("Constructor parameter of " + beanClass.getName()
                + " should be annotated by Component annotation.");
      }
      String constructorArgBeanName = annotation.value();
      if (beans.containsKey(constructorArgBeanName)) {
        constructorArgs[i] = beans.get(constructorArgBeanName);
      } else {
        constructorArgs[i] = getBean(constructorArgBeanName);
      }
    }
    Object bean = null;
    try {
      bean = constructor.newInstance(constructorArgs);
    } catch (Exception argE) {
      argE.printStackTrace();
    }
    beans.put(beanName, bean);

    return (T) bean;
  }
}
