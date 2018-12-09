package com.hillel.elementary.javageeks.examples.threads.accounts;

public class UnsafeAccount implements Account {
    private double balance;

    public UnsafeAccount(double initialDeposit) {
        balance = initialDeposit;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
