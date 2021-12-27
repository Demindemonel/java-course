package exceptions;

import exceptions.exception.UniversityDoesNotHaveFacultiesException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class University {
    private List<Faculty> facultiesList;

    public University(List<Faculty> facultiesList) {
        if (facultiesList == null || facultiesList.isEmpty() || facultiesList.stream().anyMatch(Objects::isNull)) {
            throw new UniversityDoesNotHaveFacultiesException();
        }
        this.facultiesList = facultiesList;
    }

    public List<Faculty> getFacultiesList() {
        return facultiesList;
    }

    public void setFacultiesList(List<Faculty> facultiesList) {
        this.facultiesList = facultiesList;
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

    public Student getStudentById(int studentId) {
        return facultiesList.stream()
                .flatMap(faculty -> faculty.getGroupsList().stream())
                .flatMap(group -> group.getStudentList().stream())
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst().orElse(null);
    }

    public Group getGroupById(int groupId) {
        return facultiesList.stream()
                .flatMap(faculty -> faculty.getGroupsList().stream())
                .filter(group -> group.getGroupId().equals(groupId))
                .findFirst().orElse(null);
    }

    public Faculty getFacultyById(int facultyId) {
        return facultiesList.stream()
                .filter(faculty -> faculty.getFacultyId().equals(facultyId))
                .findFirst().orElse(null);
    }
}