package exceptions;

import exceptions.exception.GradeOutOfBoundsException;

public class Grade {
    private final AcademicSubject academicSubjectName;
    private final Integer grade;

    public Grade(AcademicSubject academicSubjectName, Integer grade) {
        this.academicSubjectName = academicSubjectName;
        if (grade == null || grade < 0 || grade > 10) throw new GradeOutOfBoundsException();
        this.grade = grade;
    }

    public AcademicSubject getAcademicSubjectName() {
        return academicSubjectName;
    }

    public Integer getGrade() {
        return grade;
    }
}