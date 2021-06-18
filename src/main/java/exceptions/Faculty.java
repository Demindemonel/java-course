package exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class Faculty {
    private Integer facultyId;
    private String facultyName;
    private List<Group> groupsList;

    public Faculty(Integer facultyId, String facultyName, List<Group> groupsList) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.groupsList = groupsList;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public List<Group> getGroupsList() {
        return groupsList;
    }

    public Double getAverageScoreForSpecificSubjectInASpecificGroup(AcademicSubject subject, Integer groupId) {
        Group specificGroup = groupsList.stream().filter(group -> group.getGroupId().equals(groupId)).findFirst().orElse(null);
        List<Grade> gradesList = specificGroup.getStudentList().stream()
                .flatMap(student -> student.getGrades().stream())
                .filter(grade -> grade.getAcademicSubjectName().equals(subject))
                .collect(Collectors.toList());
        return gradesList.stream().mapToInt(Grade::getGrade).average().orElse(Double.NaN);
    }
}
