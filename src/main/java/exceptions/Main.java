package exceptions;

import java.util.ArrayList;

import static exceptions.AcademicSubject.*;

public class Main {
    public static void main(String[] args) {
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

        Group groupOne = new Group(1, new ArrayList<Student>() {
            {
                add(studentOne);
                add(studentTwo);
            }
        });

        Group groupTwo = new Group(2, new ArrayList<Student>() {
            {
                add(studentThree);
                add(studentFour);
            }
        });

        Group groupThree = new Group(2, new ArrayList<Student>() {
            {
                add(studentFive);
                add(studentSix);
            }
        });

        Faculty facultyOne = new Faculty(1, "FirstFaculty", new ArrayList<Group>() {
            {
                add(groupOne);
                add(groupTwo);
            }
        });

        Faculty facultyTwo = new Faculty(2, "SecondFaculty", new ArrayList<Group>() {{
            add(groupThree);
        }});

        University university = new University(new ArrayList<Faculty>() {
            {
                add(facultyOne);
                add(facultyTwo);
            }
        });

        System.out.println(studentFour.getAverageScore());
        System.out.println(facultyOne.getAverageScoreForSpecificSubjectInASpecificGroup(CHEMISTRY,1));
        System.out.println(university.getAverageScoreInASubject(CHEMISTRY));
    }
}
