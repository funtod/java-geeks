package com.hillel.elementary.javageeks.dir.pizza_service.context;

public interface Config {
  Class<?> getClassByBeanName(String name);
  Class<?> getBeanClassByInterface(Class<?> interfaceClass);
}
