package exceptions;

public class Grade {
    private final AcademicSubject academicSubjectName;
    private final Integer grade;

    public Grade(AcademicSubject academicSubjectName, Integer grade) {
        this.academicSubjectName = academicSubjectName;
        this.grade = grade;
    }

    public AcademicSubject getAcademicSubjectName() {
        return academicSubjectName;
    }

    public Integer getGrade() {
        return grade;
    }
}
