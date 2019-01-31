package com.hillel.elementary.javageeks.examples.reflection.annotations.users;

public class ActionManager {

    void performAction(Action action, User user) {
        Class<?> actionClass = action.getClass();
        PermissionRequired permissionRequired = actionClass.getAnnotation(PermissionRequired.class);
        if (permissionRequired != null && user != null && user.getPermissions().contains(permissionRequired.value())) {
            action.invoke(user);
        }
    }
}
