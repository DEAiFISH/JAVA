package TeamSchedule.domain;

public class Printer implements Equipment {
    private int numOfType;
    private String name;
    private String type;

    public Printer(int numOfType, String name, String type) {
        super();
        this.numOfType = numOfType;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumOfType() {
        return numOfType;
    }

    public void setNumOfType(int type) {
        this.numOfType = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }

    public String getDescribe() {
        return "23," + getType() + "," + getName();
    }
}
