package exceptions;

import java.util.Collections;
import java.util.List;

public class Student {
    private Integer studentId;
    private String studentName;
    private List<AcademicSubject> academicSubjectsList;

    public Student(Integer studentId, String studentName, List<AcademicSubject> academicSubjectsList) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.academicSubjectsList = academicSubjectsList;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<AcademicSubject> getAcademicSubjectsList() {
        return academicSubjectsList;
    }
}
