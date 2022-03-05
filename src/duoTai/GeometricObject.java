package duoTai;

public class GeometricObject {
    private String color;
    private double weight;

    public GeometricObject(){

    }

    public GeometricObject(String color,double weight){
        this.color = color;
        this.weight = weight;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public double findArea(){
        return 0;
    }
}
