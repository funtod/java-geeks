package com.hillel.elementary.javageeks.examples.threads.accounts;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            double balance = incrementAccountValue().getBalance();
            if (Double.compare(balance, 500.0) != 0) {
                System.out.println("Actual balance is: " + balance);
            }
        }
    }

    private static Account incrementAccountValue() throws InterruptedException {
        Account account = new SafeAccount(0);

        Runnable userOne = new AccountUser(account);
        Runnable userTwo = new AccountUser(account);
        Runnable userThree = new AccountUser(account);
        Runnable userFour = new AccountUser(account);
        Runnable userFive = new AccountUser(account);

        Thread threadOne = new Thread(userOne);
        Thread threadTwo = new Thread(userTwo);
        Thread threadThree = new Thread(userThree);
        Thread threadFour = new Thread(userFour);
        Thread threadFive = new Thread(userFive);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        threadFive.start();

        threadOne.join();
        threadTwo.join();
        threadThree.join();
        threadFour.join();
        threadFive.join();

        return account;
    }
}
