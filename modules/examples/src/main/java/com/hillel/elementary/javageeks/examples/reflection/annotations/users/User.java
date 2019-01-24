package com.hillel.elementary.javageeks.examples.reflection.annotations.users;

import java.util.ArrayList;
import java.util.List;

public class User {

    public User(List<Permission> permissions) {
        this.permissions = permissions;
    }

    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return new ArrayList<>(permissions);
    }


    public static enum Permission {
        USER_MANAGEMENT,
        CONTENT_MANAGEMENT
    }
}
