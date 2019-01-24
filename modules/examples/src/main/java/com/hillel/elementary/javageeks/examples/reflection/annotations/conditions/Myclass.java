package com.hillel.elementary.javageeks.examples.reflection.annotations.conditions;

@RequiredCondition(Condition.TRUE)
public class Myclass {
    public void func() {
        System.out.println("Hello");
    }
}
