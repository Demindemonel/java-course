package exceptions.service;

import exceptions.Grade;
import exceptions.Student;

import java.util.ArrayList;
import java.util.List;

import static exceptions.AcademicSubject.*;
import static exceptions.AcademicSubject.CHEMISTRY;

public class StudentsCreator {
    public static List<Student> createStudentsWithDefaultParameters() {
        Student studentOne = new Student(1, "Mary", new ArrayList<Grade>() {{
            add(new Grade(MATHEMATICS, 10));
            add(new Grade(PHYSICS, 7));
        }});
        Student studentTwo = new Student(2, "John", new ArrayList<Grade>() {{
            add(new Grade(CHEMISTRY, 8));
            add(new Grade(PHYSICS, 4));
        }});
        Student studentThree = new Student(3, "Vas", new ArrayList<Grade>() {{
            add(new Grade(PHYSICS, 9));
            add(new Grade(CHEMISTRY, 9));
            add(new Grade(MATHEMATICS, 9));
        }});
        Student studentFour = new Student(4, "Ivan", new ArrayList<Grade>() {{
            add(new Grade(PHYSICS, 6));
            add(new Grade(MATHEMATICS, 7));
        }});
        Student studentFive = new Student(5, "Petr", new ArrayList<Grade>() {{
            add(new Grade(CHEMISTRY, 2));
            add(new Grade(PHYSICS, 2));
        }});
        Student studentSix = new Student(6, "Olga", new ArrayList<Grade>() {{
            add(new Grade(PHYSICS, 1));
            add(new Grade(MATHEMATICS, 2));
            add(new Grade(CHEMISTRY, 3));
        }});
        List<Student> studentList = new ArrayList<>();
        studentList.add(studentOne);
        studentList.add(studentTwo);
        studentList.add(studentThree);
        studentList.add(studentFour);
        studentList.add(studentFive);
        studentList.add(studentSix);
        return studentList;
    }
}
