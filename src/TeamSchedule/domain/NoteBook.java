package TeamSchedule.domain;

public class NoteBook implements Equipment {
    //型号
    private int numOfType;
    private String model;
    private double price;

    public NoteBook(int numOfType, String model, double price) {
        super();
        this.numOfType = numOfType;
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumOfType() {
        return numOfType;
    }

    public void setNumOfType(int type) {
        this.numOfType = type;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }

    public String getDescribe() {
        return "22," + getModel() + "," + getPrice();
    }
}
