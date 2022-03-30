package TeamSchedule.domain;

public class PC implements Equipment {
    private int numOfType;
    private String model;
    private String display;

    public PC() {
        super();
    }

    public PC(int numOfType, String model, String display) {
        super();
        this.numOfType = numOfType;
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public int getNumOfType() {
        return numOfType;
    }

    public void setNumOfType(int type) {
        this.numOfType = type;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }

    public String getDescribe() {
        return "21," + getModel() + "," + getDisplay();
    }
}
