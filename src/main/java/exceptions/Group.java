package exceptions;

import exceptions.exception.StudentDoesNotHaveSubjectsException;

import java.util.List;
import java.util.Objects;

public class Group {
    private final Integer groupId;
    private List<Student> studentList;

    public Group(Integer groupId, List<Student> studentList) {
        this.groupId = groupId;
        if (studentList == null || studentList.isEmpty() || studentList.stream().anyMatch(Objects::isNull)) {
            throw new StudentDoesNotHaveSubjectsException();
        }
        this.studentList = studentList;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}