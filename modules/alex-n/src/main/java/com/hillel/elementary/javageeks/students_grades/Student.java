package com.hillel.elementary.javageeks.students_grades;

import java.util.ArrayList;

public class Student {

    private String surname;
    private ArrayList<Integer> grades;

    public Student(String inputSurname) {
        grades = new ArrayList<>();
        this.surname = inputSurname;
    }

    public final String getSurname() {
        return surname;
    }

    public final void addGrade(int grade) {
        this.grades.add(grade);
    }

    public final ArrayList<Integer> getGrades() {
        return grades;
    }
}
