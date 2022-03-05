import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args){
        Circle c1 = new Circle();
        System.out.print("请输入圆的半径：");
        Scanner scan = new Scanner(System.in);
        c1.r = scan.nextDouble();
        System.out.print("圆的面积为：");
        System.out.println(c1.findArea());
    }
}
class Circle{
    double r;
    final double PI = 3.1415926;

    public double findArea(){
        double area = PI * r * r;
        return area;
    }
}
