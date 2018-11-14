package com.hillel.elementary.javageeks.students_grades;

import java.util.ArrayList;

public class StudentsList {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name, int grade){
        students.add(new Student(name));
        students.get(students.size()-1).addGrade(grade);
    }

    public int getAvaregeGrade(String surname) {
        ArrayList<Integer> grades = null;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSurname().equals(surname)){
                grades = students.get(i).getGrades();
                break;
            }
        }
        int gredesSumm = 0;
        for (int grade: grades){
            gredesSumm += grade;
        }
        return gredesSumm/grades.size();
    }


    // -1 if there is no such name
    public int getStudentIndex(String name){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getSurname().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void addGrade(int studentIndex, int grade){
        students.get(studentIndex).addGrade(grade);
    }
}
