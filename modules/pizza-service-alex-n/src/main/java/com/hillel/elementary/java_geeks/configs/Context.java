package com.hillel.elementary.java_geeks.configs;

public interface Context {

    <T> T getBean (String beanName);
}
