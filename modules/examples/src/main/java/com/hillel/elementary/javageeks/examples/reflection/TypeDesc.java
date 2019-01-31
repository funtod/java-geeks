package com.hillel.elementary.javageeks.examples.reflection;

import java.lang.reflect.Member;
import java.util.HashMap;

public class TypeDesc {

    public static final String[] BASIC_TYPE_LABELS = {"class", "interface"};
    public static final String[] SUPERCLASS_LABELS = {"extends", "implements"};
    public static final String[] INTERFACE = {null, "extends"};

    String printType(Class type, int depth, String[] labels) {
        StringBuilder typeInfo = new StringBuilder();

        if (type == null) return ""; //Завершение рекурсии
        //вывод информации о текущем типе
        for (int i = 0; i < depth; i++)
            typeInfo.append(" ");

        typeInfo.append(labels[type.isInterface() ? 1 : 0]).append(" ");
        typeInfo.append(type.getName()).append("\n");

        typeInfo.append(printMembers(type.getDeclaredMethods()));
        typeInfo.append(printMembers(type.getDeclaredConstructors())) ;
        typeInfo.append(printMembers(type.getDeclaredFields()));

        // вывести информацию обо всех интерфейсах, реализуемых текущим классом
        Class[] interfaces = type.getInterfaces();

        for (Class anInterface : interfaces) {
            typeInfo.append(printType(anInterface, depth + 1, type.isInterface() ? INTERFACE : SUPERCLASS_LABELS));
        }

        // выполнить рекурсию по базовым классам
        typeInfo.append(printType(type.getSuperclass(), depth + 1, SUPERCLASS_LABELS));

        return typeInfo.toString();
    }

    private static String printMembers(Member[] members) {
        StringBuilder memberInfo = new StringBuilder();
        for (Member member : members) {
            if (member.getDeclaringClass() == Object.class)
                continue;
            memberInfo.append(member.getClass().getSimpleName()).append(":\t").append(member).append("\n");
        }
        return memberInfo.toString();
    }

    public static void main(String[] args) {
        TypeDesc desc = new TypeDesc();
        String result = desc.printType(HashMap.class, 0, BASIC_TYPE_LABELS);

        System.out.println(result);
    }
}
