package com.hillel.elementary.javageeks.students_grades;

public class StudentMarker {

    public static void MarkStudentsInFile(String path, int threshold){
        String textFromFile = GradesFileReaderWriter.ReadGradesFromFile(path);
        GradesFormatter gradesFormatter = new GradesFormatter();
        String textWithMarkedSurnames = gradesFormatter.highlightSurnameIfAverageGradeIsMoreThan(textFromFile, threshold);
        GradesFileReaderWriter.WriteGradesToFile(path, textWithMarkedSurnames);
    }
}
