package exceptions;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AcademicSubject mathematics = new AcademicSubject(1, "mathematics");
        AcademicSubject physics = new AcademicSubject(2, "physics ");
        AcademicSubject chemistry = new AcademicSubject(3, "chemistry");
        Student studentOne = new Student(1, "Mary", new ArrayList<AcademicSubject>(){{add(mathematics);add(physics);}});
        Student studentTwo = new Student(2,"John", new ArrayList<AcademicSubject>(){{add(chemistry);add(physics);}});
        Student studentThree = new Student(3,"Vas", new ArrayList<AcademicSubject>(){{add(chemistry);add(physics);add(mathematics);}});
    }
}
