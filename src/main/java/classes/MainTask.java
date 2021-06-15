package classes;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainTask {
    public static void main(String[] args) throws ParseException {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Klimenkov",
                "Dmitry",
                "Ruhorovich",
                new SimpleDateFormat("dd/MM/yyyy").parse("28/11/1996"),
                "Dimitrova Avenue",
                "88005553535",
                "ASOI",
                4,
                141));
        students.add(new Student(2, "Ivanov",
                "Ivan",
                "Ivanovich",
                new SimpleDateFormat("dd/MM/yyyy").parse("01/11/1996"),
                "Ivanova Avenue",
                "1234567890",
                "ASOI",
                4,
                151));
        students.add(new Student(3, "Petrov",
                "Petr",
                "Petrovich",
                new SimpleDateFormat("dd/MM/yyyy").parse("12/01/1995"),
                "Dimitrova Avenue",
                "9876543210",
                "FM",
                5,
                131));
        students.add(new Student(4, "Testov",
                "Test",
                "Testovich",
                new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1991"),
                "Test Avenue",
                "010101010101",
                "TEST",
                1,
                141));


        List<Student> studentsByFaculty = students.stream().filter(student -> student.getFaculty().equals("ASOI")).collect(Collectors.toList());
        System.out.println(studentsByFaculty.toString());


        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1994");
        List<Student> studentsByBirthDate = students.stream().filter(student -> student.getBirthDate().after(date)).collect(Collectors.toList());
        System.out.println(studentsByBirthDate.toString());


        List<Student> studentsByGroup = students.stream().filter(student -> student.getGroup() == 141).collect(Collectors.toList());
        System.out.println(studentsByGroup.toString());
    }

}
