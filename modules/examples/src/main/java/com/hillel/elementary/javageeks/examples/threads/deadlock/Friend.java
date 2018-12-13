package com.hillel.elementary.javageeks.examples.threads.deadlock;

public class Friend {
    private Friend partner;
    private String name;

    public Friend(String name) {
        this.name = name;
    }

    public synchronized void hug() {
        System.out.println(Thread.currentThread().getName() +
                " в " + name + ".hug() пытается вызвать " + partner.name + ".hugBack()");
        partner.hugBack();
    }

    private synchronized void hugBack() {
        System.out.println(Thread.currentThread().getName() + " в " + name + ".hugBack()");

    }

    public void becomeFriend(Friend partner) {
        this.partner = partner;
    }

}
