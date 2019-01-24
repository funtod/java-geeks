package com.hillel.elementary.java_geeks.configs;

public interface Config {

    public Class<?> getBeanClassByName(String name);

    public Class<?> getBeanClassByInterface(Class<?> interfaceClass);
}
