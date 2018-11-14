package com.hillel.elementary.javageeks.students_grades;

public class GradesFormatter {

    public String[] splitByLines(String text){
        return text.split("[\\n\\r]");
    }

    public String hilightSurnameIfAverageGradeIsMoreThan(String text, int threshold){
        String[] lines = splitByLines(text);
        StringBuilder stringBuilder = new StringBuilder();
        StudentsList studentsList = new StudentsList();

        for (int i = 0; i < lines.length; i++) {
            String name = lines[i].split("-")[0].trim();
            Integer grade = Integer.parseInt(lines[i].split("-")[1].trim());
            int studentIndex;
            if ((studentIndex = studentsList.getStudentIndex(name)) < 0){
                studentsList.addStudent(name, grade);
            }else {
                studentsList.addGrade(studentIndex, grade);
            }
        }
        for (int i = 0; i < lines.length; i++) {
            String studentName = lines[i].split("-")[0].trim();
            if (studentsList.getStudentIndex(studentName) > 0){
                if (studentsList.getAvaregeGrade(studentName) > threshold){
                    stringBuilder.append(lines[i].toUpperCase()+"\n");
                }
            }else {
                stringBuilder.append(lines[i]+"\n");
            }
        }
        return stringBuilder.toString();
    }
}
