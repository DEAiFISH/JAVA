public class text {
    public static void main(String[] args) {
        P p1 = new P();
        p1.get();
    }

}
class People {
    private int age = 0;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class P {
    private int mustAge;
    public void get(){
        People p1 = new People();
        mustAge = p1.getAge();
        System.out.println(mustAge);
    }
}
