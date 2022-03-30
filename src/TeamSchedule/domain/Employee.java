package TeamSchedule.domain;

/**
 * 普通员工
 */
public class Employee {
    private int numOfPosition;
    private String name;
    private int id;
    private int age;
    //薪水
    private double salary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {

    }

    public Employee(int numOfPosition, int id, String name, int age, double salary) {
        this.numOfPosition = numOfPosition;
        this.name = name;
        this.id = id;
        this.age = age;
        this.salary = salary;
    }

    public int getNumOfPosition() {
        return numOfPosition;
    }

    /**
     * 获取详细信息
     *
     * @return String
     */
    public String getDetails() {
        return id + "\t" + name + "\t" + age + "\t\t" + salary + "\t";
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + age + "\t\t" + salary + "\t\t普通员工";
    }
}
