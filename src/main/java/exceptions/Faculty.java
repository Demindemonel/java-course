package exceptions;

import java.util.List;

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
}
