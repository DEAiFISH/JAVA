import java.util.Scanner;

public class 构造器 {
    public static void main(String[] args){
        Person p1 = new Person("Tom");
        System.out.println("name = " + p1.get_name());
        System.out.println("age = " + p1.get_age());
        System.out.println("legs = " + p1.get_legs());

        Person p2 = new Person("Lily");
        System.out.println("name = " + p2.get_name());
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入年龄：");
        int age = scan.nextInt();
        p2.set_age(age);
        System.out.print("请输入：");
        int legs = scan.nextInt();
        p2.set_legs(legs);
        System.out.println("age = " + p2.get_age());
        System.out.println("legs = " + p2.get_legs());
    }
}
class Person{
    private String name;
    private int age;
    private int legs;

    public Person(String name){
        this.name = name;
        age = 18;
        legs = 4;
    }

    public  void set_age(int age){
        if(age >= 0 && age <= 130){
            this.age = age;
        }
        else{
            System.out.println("error");
            Scanner scan = new Scanner(System.in);
            age = scan.nextInt();
            set_age(age);
        }
    }
    public  void set_legs(int legs){
        if(legs >= 0 && legs <= 4){
            this.legs = legs;
        }
        else{
            System.out.println("error");
            Scanner scan = new Scanner(System.in);
            legs = scan.nextInt();
            set_legs(legs);
        }
    }

    public int get_age(){
        return age;
    }
    public String get_name(){
        return name;
    }
    public int get_legs(){
        return legs;
    }
}

// this 也可以调用本类中的构造器  this(形参列表)；
//      只能放构造器的第一行且只能调用一哥构造器