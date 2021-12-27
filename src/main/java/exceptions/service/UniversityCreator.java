package exceptions.service;

import exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class UniversityCreator {
    public static University createUniversityWithDefaultParameters() {
        List<Faculty> facultyList = FacultiesCreator.createFacultiesWithDefaultParameters();
        return new University(new ArrayList<Faculty>() {
            {
                add(facultyList.get(0));
                add(facultyList.get(1));
            }
        });
    }
}
