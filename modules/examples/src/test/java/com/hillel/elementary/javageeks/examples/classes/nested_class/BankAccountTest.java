package com.hillel.elementary.javageeks.examples.classes.nested_class;

import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void name() {
        BankAccount bankAccount = new BankAccount();

        BankAccount.Permission denied =  bankAccount.new Permission("denied");
    }
}