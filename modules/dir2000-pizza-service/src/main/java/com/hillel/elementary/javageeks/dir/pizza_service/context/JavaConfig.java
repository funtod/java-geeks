package com.hillel.elementary.javageeks.dir.pizza_service.context;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;
import com.hillel.elementary.javageeks.dir.pizza_service.utility.Logging;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class JavaConfig implements Config {

    private Map<String, Class<?>> classes = new HashMap<>();

    public JavaConfig() {
        try {
            ArrayList<Class> allClasses = getAllClasses();
            for (Class aClass : allClasses) {
                Component annotation = (Component) aClass.getAnnotation(Component.class);
                if (annotation != null) {
                    String name = annotation.value().isEmpty() ? aClass.getSimpleName() : annotation.value();
                    if (classes.put(name, aClass) != null) {
                        throw new IllegalStateException(String.format("More than one bean with name %s can't be registered", name));
                    }
                }
            }
        } catch (Exception ex) {
            Logging.logStackTrace(ex);
            throw new IllegalStateException("Unable to find Component classes");
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

                Class<?> clazz = Class.forName(packageName.substring(1).replace("/", ".")
                        + '.' + file.getName().substring(0, file.getName().length() - 6));
                classes.add(clazz);
            }
        }
        return classes;
    }

    @Override
    public Class<?> getClassByBeanName(String name) {
        Class<?> aClass = classes.get(name);
        if (aClass == null) {
            throw new IllegalStateException(String.format("No class for beanName: %s found", name));
        }
        return aClass;
    }

    @Override
    public Class<?> getBeanClassByInterface(Class<?> interfaceClass) {
        for (Class<?> clazz: classes.values()) {
            Class<?>[] interfaces = clazz.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                if (interfaces[i] == interfaceClass) {
                    return clazz;
                }
            }
        }
        throw new IllegalStateException(String.format("No class for interface: %s found", interfaceClass));
    }
}