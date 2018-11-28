package com.hillel.elementary.javageeks.students_grades;

import java.util.ArrayList;

public class StudentsGrades {

    private ArrayList<Student> students = new ArrayList<>();

    public final void  addStudent(String name, int grade) {
        students.add(new Student(name));
        students.get(students.size() - 1).addGrade(grade);
    }

    public final int getAverageGrade(String surname) {
        ArrayList<Integer> grades = null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSurname().equals(surname)) {
                grades = students.get(i).getGrades();
                break;
            }
        }
        int gradesSum = 0;
        for (int grade: grades) {
            gradesSum += grade;
        }
        return gradesSum / grades.size();
    }


    // -1 if there is no such name
    public final int getStudentIndex(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSurname().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public final void addGrade(int studentIndex, int grade) {
        students.get(studentIndex).addGrade(grade);
    }
}
