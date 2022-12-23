import java.util.List;
import java.util.Map;

public interface StudentService {
    String createStudent(List<Student> students);

    List<Student> getAll();

    Map<Integer, Student> getAge(List<Student> students);

    String debt(String name, List<Student> students,
                String name1, List<Student> students1, int summa);

    List<Student> findByName(String name, List<Student> students);

    String removeByName(String name);

    String removeById(Long id);

    List<Student> findGender(String name);

    List<Student> sortMoney(String asc);

    List<Student> sortByName(String desc);

    Student addStudent();
}
