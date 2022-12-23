import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Exam task");

        List<Student> studentList = new ArrayList<>();
               studentList.add(new Student("Aigerim", 17, Gender.FEMALE,
                        LocalDate.of(2005,21,6),new BigDecimal(250000),1L));
                studentList.add(new Student("Oomat", 15, Gender.MALE,
                        LocalDate.of(2008,2,20), new BigDecimal(30000),2L));


        StudentServiceImpl service = new StudentServiceImpl();

        List<Student> students = new ArrayList<>();

        System.out.println("<<<Commands>>>");
        System.out.println("""
                1 -> createStudent,
                2 -> getAllStudent,
                3 -> getAge,
                4 -> debt,
                5 -> findByName,
                6 -> removeByName,
                7 -> removeById,
                8 -> findGender,
                9 -> sortByMoney,
                10 -> sortByName,
                11 -> addStudent
                """);
        while (true){
            int num = scanner.nextInt();

            switch (num){
                case 1:
                    System.out.println(service.createStudent(students));
                    break;
                case 2:
                    System.out.println(service.getAll());
                    break;
                case 3:
                    System.out.println(service.getAge(students));
                    break;
                case 4:
                    System.out.println("Enter first Student name: ");
                    String firstName = new Scanner(System.in).nextLine();
                    System.out.println("Enter second Student name: ");
                    String secondName = new Scanner(System.in).nextLine();
                    System.out.println("Summa: ");
                    int summa = 0;
                    System.out.println(service.debt(firstName,students,secondName,students,summa));
                    break;
                case 5:
                    System.out.println(service.findGender(scanner.nextLine()));
                    break;
                case 6:
                    System.out.println(service.removeByName("Aigerim"));
                    break;
                case 7:
                    System.out.println(service.removeById(1L));
                    break;
                case 8:
                    System.out.println(service.findGender(String.valueOf(Gender.FEMALE)));
                    break;
                case 9:
                    System.out.println(service.sortMoney(studentList.toString()));
                    break;
                case 10:
                    System.out.println(service.sortByName(students.toString()));
                case 11:
                    System.out.println(service.addStudent());
                default:
                    System.out.println("There is no such method!");
            }
        }




    }
}