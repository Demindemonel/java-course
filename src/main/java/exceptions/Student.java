package exceptions;

import java.util.List;

public class Student {
    private Integer studentId;
    private String studentName;
    private List<Grade> grades;

    public Student(Integer studentId, String studentName, List<Grade> grades) {
        this.studentId = studentId;
        this.studentName = studentName;
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

    public Double getAverageScore() {
        return grades.stream().mapToInt(Grade::getGrade).average().orElse(Double.NaN);
    }
}
