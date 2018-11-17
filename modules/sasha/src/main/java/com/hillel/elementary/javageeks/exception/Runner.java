package com.hillel.elementary.javageeks.exception;


class A  {
    void givException()throws Exception{
        throw new Exception();
    }

}
class B extends A{
    @Override
    public void givException()throws Exception{
        throw new ArithmeticException();

    }

}
class C extends B{

}

public class Runner {
    public static void run()throws Exception{
        C cObj = new C();
        A aObj = cObj;

        aObj.givException();


    }
}
