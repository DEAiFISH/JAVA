package duoTai;

import static java.lang.Math.*;

public class Circle extends GeometricObject{
    private double radius;

    Circle(){
        super();
    }

    Circle(double radius,String color,double weight){
        super(color,weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double findArea(){
        return PI * pow(radius,2.0);
    }

    //重写equals
    @Override
    public boolean equals(Object obj){
        if(obj.getClass() != getClass()){
            return false;
        }
        if(obj == null){
            return false;
        }
        if(obj == this){
            return true;
        }

        Circle c1 = new Circle();
        c1 = (Circle) obj;
        return this.getColor().equals(c1.getColor());
    }

    @Override
    public String toString(){
        return "[radius = " + radius + "]";
    }
}
