package exceptions;

public class AcademicSubject {
    private Integer academicSubjectId;
    private String academicSubjectName;

    public AcademicSubject(Integer academicSubjectId, String academicSubjectName) {
        this.academicSubjectId = academicSubjectId;
        this.academicSubjectName = academicSubjectName;
    }

    public Integer getAcademicSubjectId() {
        return academicSubjectId;
    }

    public String getAcademicSubjectName() {
        return academicSubjectName;
    }
}
