package com.hillel.elementary.javageeks.examples.reflection.annotations.users;

@PermissionRequired(User.Permission.USER_MANAGEMENT)
public class UserDeleteAction implements Action {
    public void invoke(User user) {

    }
}