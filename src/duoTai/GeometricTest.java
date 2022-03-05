package duoTai;

public class GeometricTest {
    public static void main(String[] args){
        GeometricTest test = new GeometricTest();
        Circle c1 = new Circle(2.3,"white",2.0);
        test.displayGeometricObject(c1);
        Circle c2 = new Circle(3.3,"white",1.0);
        test.displayGeometricObject(c2);

        boolean isEquals = test.equalsArea(c1,c2);
        System.out.println("c1,c2的面积是否相等：" + isEquals);

        MyRectangle m1 = new MyRectangle(2.1,3.4,"white",6.0);
        test.displayGeometricObject(m1);
        MyRectangle m2 = new MyRectangle(3.1,3.4,"white",6.0);
        test.displayGeometricObject(m2);

        isEquals = test.equalsArea(m1,m2);
        System.out.println("m1,m2的面积是否相等：" + isEquals);


        System.out.println("*******************");
        boolean isFlag;
        isFlag = c1.equals(c2);
        System.out.println(isFlag);
        System.out.println(c1);
    }

    //多态的使用
    public void displayGeometricObject(GeometricObject o){
        System.out.println("面积为：" + o.findArea());
    }
    public boolean equalsArea(GeometricObject o1,GeometricObject o2){
        return o1.findArea() == o2.findArea();
    }
}
