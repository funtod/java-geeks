package com.hillel.elementary.javageeks.examples.classes;

import java.util.Date;

public final class ImmutableUser {

    private String name;
    private Date birthDate;

    public ImmutableUser(String name, Date birthDate) {
        this.name = name;
        this.birthDate = getDateCopy(birthDate);
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return getDateCopy(birthDate);
    }

    private Date getDateCopy(Date birthDate) {
        return new Date(birthDate.getTime());
    }
}
