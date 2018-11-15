package com.hillel.elementary.javageeks.students_grades;

import java.util.ArrayList;

public class Student {

    private String surname;
    private ArrayList<Integer> grades;

    public Student(String surname) {
        grades = new ArrayList<>();
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void addGrade(int grade) {
        this.grades.add(grade);
    }

    public ArrayList<Integer> getGrades(){
        return grades;
    }
}
