package com.hillel.elementary.javageeks.examples.classes.nested_static_class;

public class BankAccount {
    private long number;
    private static long accountsCreated = 0;

    public static class Permission {
        public String permissionType;

        public Permission(String permissionType) {
            this.permissionType = permissionType;
        }

        public void func() {
            accountsCreated = 10;
            //number = 1; ошибка компиляции
        }
    }
}
