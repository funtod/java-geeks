package com.hillel.elementary.javageeks.students_grades;

import java.util.ArrayList;

public class Student {

    private String surname;
    private ArrayList<Integer> grades;

    public Student(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public ArrayList<Integer> getGrades(){
        return grades;
    }
}
