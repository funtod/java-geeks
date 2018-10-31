package com.hillel.elementary.javageeks.examples.classes.nested_static;

import com.hillel.elementary.javageeks.examples.classes.nested_static_class.BankAccount;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void name() {
        BankAccount.Permission denied =  new BankAccount.Permission("denied");
    }
}