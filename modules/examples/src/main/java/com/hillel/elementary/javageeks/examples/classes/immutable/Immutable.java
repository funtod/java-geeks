package com.hillel.elementary.javageeks.examples.classes.immutable;

import java.util.Date;

public final class Immutable {
    private String name;
    private int id;
    private Date date;

    public Immutable (String name, int id, Date date) {
        this.name = name;
        this.id = id;
//        this.date = (Date) date.clone();
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
//        return (Date) date.clone();
        return date;
    }
}
