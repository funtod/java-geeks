package com.hillel.elementary.javageeks.students_grades;

public class GradesFormatter {

    private String[] splitByLines(String text) {
        return text.split("[\\n\\r]");
    }

    //threshold is not included
    public String highlightSurnameIfAverageGradeIsMoreThan(String text, int threshold) {
        if (text == null || text.isEmpty() || threshold < 0) {
            return text;
        }

        String[] lines = splitByLines(text);
        StringBuilder stringBuilder = new StringBuilder();
        StudentsGrades studentsGrades = new StudentsGrades();

        for (int i = 0; i < lines.length; i++) {
            String name = lines[i].split("-")[0].trim();
            Integer grade = Integer.parseInt(lines[i].split("-")[1].trim());
            int studentIndex;
            if ((studentIndex = studentsGrades.getStudentIndex(name)) < 0) {
                studentsGrades.addStudent(name, grade);
            } else {
                studentsGrades.addGrade(studentIndex, grade);
            }
        }
        for (int i = 0; i < lines.length; i++) {
            String studentName = lines[i].split("-")[0].trim();
            if (studentsGrades.getAverageGrade(studentName) > threshold) {
                stringBuilder.append(lines[i].toUpperCase());
            } else {
                stringBuilder.append(lines[i]);
            }
            if (i < lines.length - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
