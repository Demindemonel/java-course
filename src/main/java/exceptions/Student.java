package exceptions;

import exceptions.exception.StudentDoesNotHaveSubjectsException;

import java.util.List;
import java.util.Objects;

public class Student {
    private final Integer studentId;
    private String studentName;
    private List<Grade> grades;

    public Student(Integer studentId, String studentName, List<Grade> grades) {
        this.studentId = studentId;
        this.studentName = studentName;
        if (grades == null || grades.isEmpty() || grades.stream().anyMatch(Objects::isNull)) {
            throw new StudentDoesNotHaveSubjectsException();
        }
        this.grades = grades;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Double getAverageScore() {
        return grades.stream().mapToInt(Grade::getGrade).average().orElse(Double.NaN);
    }
}