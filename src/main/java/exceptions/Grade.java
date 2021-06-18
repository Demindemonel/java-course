package exceptions;

public class Grade {
    private AcademicSubject academicSubjectName;
    private Integer grade;

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
