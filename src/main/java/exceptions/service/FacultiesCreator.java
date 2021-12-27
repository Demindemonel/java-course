package exceptions.service;

import exceptions.Faculty;
import exceptions.Group;

import java.util.ArrayList;
import java.util.List;

public class FacultiesCreator {
    public static List<Faculty> createFacultiesWithDefaultParameters() {
        List<Group> groupList = GroupsCreator.createGroupsWithDefaultParameters();
        Faculty facultyOne = new Faculty(1, "FirstFaculty", new ArrayList<Group>() {
            {
                add(groupList.get(0));
                add(groupList.get(1));
            }
        });
        Faculty facultyTwo = new Faculty(2, "SecondFaculty", new ArrayList<Group>() {{
            add(groupList.get(2));
        }});
        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(facultyOne);
        facultyList.add(facultyTwo);
        return facultyList;
    }
}
