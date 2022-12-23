import java.math.BigDecimal;
import java.time.LocalDate;

public class Student {
    private String name;
    private int age;
    private Gender gender;
    private LocalDate yearOfBirth;
    private BigDecimal money;
    private Long id;

    public Student(){

    }


    public Student(String name, int age, Gender gender, LocalDate yearOfBirth, BigDecimal money, Long id) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.money = money;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(LocalDate yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name: " + name + "\n" +
                "age: " + age +
                "gender: " + gender +
                "yearOfBirth: " + yearOfBirth +
                "money: " + money +
                "id: " + id ;
    }
}
