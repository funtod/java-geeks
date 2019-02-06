package com.hillel.elementary.javageeks.examples.reflection.annotations.conditions;

public class Main {
    public static void main(String[] args) throws Exception {
        Myclass myclass = new Myclass();
        Class<?> myclassClass = Myclass.class;
        RequiredCondition cd = myclassClass.getAnnotation(RequiredCondition.class);
        System.out.println(cd.value()); //На экране true
    }
}
