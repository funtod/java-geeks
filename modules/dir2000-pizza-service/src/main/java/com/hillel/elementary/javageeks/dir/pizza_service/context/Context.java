package com.hillel.elementary.javageeks.dir.pizza_service.context;

public interface Context {
  <T> T getBean(String beanName);
}
