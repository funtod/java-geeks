package com.hillel.elementary.java_geeks.configs;

public interface Config {

    void measureTimedMethodsPerformance();

    public Class<?> getBeanClassByName(String name);

    public Class<?> getBeanClassByInterface(Class<?> interfaceClass);
}
