package com.hillel.elementary.javageeks.students_grades;

public final class StudentMarker {

    private StudentMarker() { }

    public static void markStudentsInFile(String path, int threshold) {
        String textFromFile = GradesFileReaderWriter.readFromFile(path);
        GradesFormatter gradesFormatter = new GradesFormatter();
        String textWithMarkedSurnames = gradesFormatter.highlightSurnameByAverageGrade(textFromFile, threshold);
        GradesFileReaderWriter.writeToFile(path, textWithMarkedSurnames);
    }
}
