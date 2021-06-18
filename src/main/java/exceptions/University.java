package exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class University {
    private final List<Faculty> facultiesList;

    public University(List<Faculty> facultiesList) {
        this.facultiesList = facultiesList;
    }

    public List<Faculty> getFacultiesList() {
        return facultiesList;
    }

    public Double getAverageScoreInASubject(AcademicSubject subject) {
        return facultiesList.stream()
                .flatMap(faculty -> faculty.getGroupsList().stream())
                .flatMap(group -> group.getStudentList().stream())
                .flatMap(student -> student.getGrades().stream())
                .filter(grade -> grade.getAcademicSubjectName().equals(subject))
                .collect(Collectors.toList()).stream()
                .mapToInt(Grade::getGrade)
                .average()
                .orElse(Double.NaN);
    }
}
