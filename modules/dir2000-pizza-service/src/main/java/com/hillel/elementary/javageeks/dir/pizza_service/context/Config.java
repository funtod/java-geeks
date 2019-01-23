package com.hillel.elementary.javageeks.dir.pizza_service.context;

import java.io.IOException;
import java.util.List;

public interface Config {
  Class<?> getClassByBeanName(String name);
  Class<?> getBeanClassByInterface(Class<?> interfaceClass);
}
