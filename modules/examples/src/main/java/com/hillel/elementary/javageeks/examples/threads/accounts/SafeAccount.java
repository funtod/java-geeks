package com.hillel.elementary.javageeks.examples.threads.accounts;

import com.hillel.elementary.javageeks.examples.threads.synchronize.Body;

public class SafeAccount implements Account {
    private double balance; //данное поле защищеное от любых несинхронных действий

    public SafeAccount(double initialDeposit) {
        balance = initialDeposit;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        synchronized (this) {
            balance += amount;
        }
    }
}
