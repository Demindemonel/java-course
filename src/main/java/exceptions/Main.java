package exceptions;

import exceptions.service.UniversityCreator;

import static exceptions.AcademicSubject.*;

public class Main {
    public static void main(String[] args) {
        University university = UniversityCreator.createUniversityWithDefaultParameters();

        System.out.println(university.getStudentById(4).getAverageScore());
        System.out.println(university.getFacultyById(1).getAverageScoreForSpecificSubjectInASpecificGroup(CHEMISTRY, 1));
        System.out.println(university.getAverageScoreInASubject(CHEMISTRY));
    }
}
