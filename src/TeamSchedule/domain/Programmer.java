package TeamSchedule.domain;

import TeamSchedule.service.Status;

public class Programmer extends Employee {
    //状态
    private Status status = Status.FREE;
    //设备
    private Equipment equipment;
    //团队ID
    private int TID;

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.getDetails() + "\t程序员\t" + status + "\t\t\t\t\t\t" + equipment.getDescription();
    }

    public String getDetailsForTeam() {
        return TID + "/" + this.getId() + "\t\t" + this.getName() + "\t" + this.getAge() + "\t\t" + this.getSalary() + "\t\t程序员";
    }
}
