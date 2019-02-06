package com.hillel.elementary.javageeks.examples.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyExample {

    public static void main(String[] args) {
        Account account = new MyAccount();
        Account instance = (Account) Proxy.newProxyInstance(
                ProxyExample.class.getClassLoader(),
                new Class[]{Account.class, Cloneable.class},
                new MyAccountProxy(account));

        instance.changeBalance(100);
        instance.percents(-100);

        System.out.println(instance.getBalance());
    }
}

interface Account {
    Double getBalance();
    void changeBalance(int sum);
    void percents(double per);
}

class MyAccount implements Account {
    private double balance;

    public MyAccount() {
        balance = 0.0;
    }

    public Double getBalance() {
        return balance;
    }

    public void changeBalance(int sum) {
        balance += sum;
    }

    public void percents(double per) {
        balance += balance * per / 100;
    }
}

class NewProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        System.out.println(Arrays.toString(args));
        return null;
    }
}

@Description(title="title", version=2, text="text")
class MyAccountProxy implements InvocationHandler {
    private Account ac;

    public MyAccountProxy(Account acc) {
        ac = acc;
    }

    public static Account newInstance(Account da) {

        return (Account) Proxy.newProxyInstance(
                da.getClass().getClassLoader(),
                da.getClass().getInterfaces(),
                new MyAccountProxy(da));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("percents")) {
            double doubleArgument = (Double) args[0];
            if (doubleArgument < 0) doubleArgument = 0;
            if (doubleArgument > 30) doubleArgument = 30;
            args[0] = doubleArgument;
            return method.invoke(ac, args);
        } else {
            return method.invoke(ac, args);
        }
    }
}

@interface Description {
    String title();
    int version() default 1;
    String text();
}
