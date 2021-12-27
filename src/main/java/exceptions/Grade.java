package exceptions;

import exceptions.exception.GradeOutOfBoundsException;

public class Grade {
    private AcademicSubject academicSubjectName;
    private Integer grade;

    public Grade(AcademicSubject academicSubjectName, Integer grade) {
        this.academicSubjectName = academicSubjectName;
        if (grade == null || grade < 0 || grade > 10) {
            throw new GradeOutOfBoundsException();
        }
        this.grade = grade;
    }

    public AcademicSubject getAcademicSubjectName() {
        return academicSubjectName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setAcademicSubjectName(AcademicSubject academicSubjectName) {
        this.academicSubjectName = academicSubjectName;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}