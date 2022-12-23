import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class StudentServiceImpl implements StudentService{

    List<Student> students = new ArrayList<>();
    @Override
    public String createStudent(List<Student> students) {
        this.students.addAll(students);
        return "Successfully!";
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Map<Integer, Student> getAge(List<Student> students) {
        Map<Integer, Student> map = new HashMap<>();
        for (Student student : this.students) {
            int years = Period.between(student.getYearOfBirth(), LocalDate.now()).getYears();
            map.put(years,student);

        }
        return map;
    }

    @Override
    public String debt(String name, List<Student> students, String name1, List<Student> students1, int summa) {
        for (Student student : students) {
            if (student.getName().equals(name)){
                for (Student student1 : students) {
                    if (student1.getName().equals(name1)){
                       int s = student1.getMoney().intValue();
                       if (s>=0){
                           student1.setMoney(student.getMoney().subtract(BigDecimal.valueOf(summa)));
                           student.setMoney(student1.getMoney().add(BigDecimal.valueOf(summa)));
                       } else  {
                           System.out.println("I don't have that much money.");
                       }
                    }
                }
            }

        }
        return "Successfully debt!";
    }

    @Override
    public List<Student> findByName(String name, List<Student> students) {
        for (Student student : students) {
            if (student.getName().equals(name)){
                students.add(student);
            }
        }
        return students;
    }
    @Override
    public String removeByName(String name) {
        students.removeIf(student -> student.getName().equals(name));
        return "Name deleted! ";
    }
    @Override
    public String removeById(Long id) {
        students.removeIf(student -> Objects.equals(student.getId(), id));
        return "Deleted ID! ";
    }
    @Override
    public List<Student> findGender(String name) {
        return students.stream().filter(x->x.getGender().equals(Gender.valueOf(name.toUpperCase()))).toList();
    }
    @Override
    public List<Student> sortMoney(String asc) {
        return students.stream().sorted(Comparator.comparing(Student::getMoney)).toList();
    }
    @Override
    public List<Student> sortByName(String desc) {
       students.sort(Comparator.comparing(Student::getName));
        return students;
    }
    @Override
    public Student addStudent() {
        System.out.println("Enter a name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter a age: ");
        int age = new Scanner(System.in).nextInt();
        System.out.println("Gender: ");
        String gender = new Scanner(System.in).nextLine().toUpperCase();
        System.out.println("Year of birth: ");
        String[] yearOfBirth = new Scanner(System.in).nextLine().trim().split("-");
        System.out.println("Money: ");
        BigDecimal money = new Scanner(System.in).nextBigDecimal();
        System.out.println("ID: ");
        Long id = new Scanner(System.in).nextLong();

        LocalDate localDate = LocalDate.of(
                Integer.parseInt(yearOfBirth[0]),
                Integer.parseInt(yearOfBirth[1]),
                Integer.parseInt(yearOfBirth[2])
        );


        return new Student(name,age,Gender.valueOf(gender),localDate,money,id);
    }
}
