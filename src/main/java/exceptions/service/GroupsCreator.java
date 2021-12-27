package exceptions.service;

import exceptions.Group;
import exceptions.Student;

import java.util.ArrayList;
import java.util.List;

public class GroupsCreator {
    public static List<Group> createGroupsWithDefaultParameters() {
        List<Student> studentList = StudentsCreator.createStudentsWithDefaultParameters();
        Group groupOne = new Group(1, new ArrayList<Student>() {
            {
                add(studentList.get(0));
                add(studentList.get(1));
            }
        });
        Group groupTwo = new Group(2, new ArrayList<Student>() {
            {
                add(studentList.get(2));
                add(studentList.get(3));
            }
        });
        Group groupThree = new Group(2, new ArrayList<Student>() {
            {
                add(studentList.get(4));
                add(studentList.get(5));
            }
        });
        List<Group> groupList = new ArrayList<>();
        groupList.add(groupOne);
        groupList.add(groupTwo);
        groupList.add(groupThree);
        return groupList;
    }
}
