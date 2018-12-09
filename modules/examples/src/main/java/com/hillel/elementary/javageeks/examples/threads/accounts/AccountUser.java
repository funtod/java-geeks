package com.hillel.elementary.javageeks.examples.threads.accounts;

public class AccountUser implements Runnable {
    private Account account;

    public AccountUser(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.deposit(1);
        }
    }
}
