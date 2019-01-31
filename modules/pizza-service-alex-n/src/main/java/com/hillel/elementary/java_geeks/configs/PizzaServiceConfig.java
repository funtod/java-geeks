package com.hillel.elementary.java_geeks.configs;

import com.hillel.elementary.java_geeks.configs.anotations.Component;
import com.hillel.elementary.java_geeks.exceptions.AppInitialisationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class PizzaServiceConfig implements Config {

    private static final Logger LOGGER = LoggerFactory.getLogger(PizzaServiceConfig.class);
    private Map<String, Class<?>> classes = new HashMap<>();

    public PizzaServiceConfig() throws AppInitialisationException {

        ArrayList<Class> allClasses = null;

        try {
            allClasses = getAllClasses();
        } catch (NullPointerException | IOException | ClassNotFoundException e) {
            String msg = "Can`t load some classes: ";
            LOGGER.error(msg, e);
            throw new AppInitialisationException(msg + e);
        }

        for (Class aClass : allClasses) {
            Component annotation = (Component) aClass.getAnnotation(Component.class);
            if (annotation != null) {
                String name = annotation.value().isEmpty() ? aClass.getSimpleName() : annotation.value();
                if (classes.put(name, aClass) != null) {
                    LOGGER.error(String.format("More than one bean with name%s can't be registered", name));
                }
            }
        }
    }


    private ArrayList<Class> getAllClasses() throws IOException, ClassNotFoundException {
        Enumeration<URL> resources = getClass().getClassLoader().getResources("");
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, ""));
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files != null ? files : new File[0]) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                Class<?> clazz = Class.forName(packageName.substring(1).replace("/", ".") +
                        '.' + file.getName().substring(0, file.getName().length() - 6));
                classes.add(clazz);
            }
        }
        return classes;
    }

    @Override
    public Class<?> getBeanClassByName(String name) {
        Class<?> aClass = classes.get(name);
        if (aClass == null) {
            LOGGER.error(String.format("No class for beanName: %s was found", name));
        }
        return aClass;
    }

    @Override
    public Class<?> getBeanClassByInterface(Class<?> interfaceClass) {
        for (Class<?> clazz : classes.values()) {
            Class<?>[] interfaces = clazz.getInterfaces();
            Class<?> tmpClass = clazz;

            while (interfaces.length == 0) {
                tmpClass = tmpClass.getSuperclass();
                if (tmpClass == null) {
                    break;
                } else {
                    interfaces = tmpClass.getInterfaces();
                }
            }

            for (Class<?> anInterface : interfaces) {
                if (anInterface == interfaceClass) {
                    return clazz;
                }
            }
        }

        LOGGER.error(String.format("No class for interface: %s was found", interfaceClass));
        return null;
    }
}
