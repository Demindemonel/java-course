package exceptions;

import java.util.List;

public class Group {
    private final Integer groupId;
    private final List<Student> studentList;

    public Group(Integer groupId, List<Student> studentList) {
        this.groupId = groupId;
        this.studentList = studentList;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
