package com.hillel.elementary.javageeks.exception;


class A  {
    void givException() throws  HigherException {
        throw new HigherException();

    }

}
class B extends A{
    @Override
    public void givException()throws HigherException{
        throw new MidleException();

    }

}
class C extends B{
    public void givException()throws MidleException{
        throw new LowerException();
    }

}

public class Runner {
    public static void run() throws Exception {
        C cObj = new C();
        A aObj = cObj;


        aObj.givException();




    }
}
