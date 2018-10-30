package com.hillel.elementary.javageeks.examples.classes.final_class;

public class FinalMethodClass {
    final int number;

    FinalMethodClass() {
        number = 1; //обязательна инициализация в конструкторе или при инициализации поля
    }

    public final void doSomething() {

    }
}

class ChildClass extends FinalMethodClass {

//    public void doSomething() {
//
//    }

}
