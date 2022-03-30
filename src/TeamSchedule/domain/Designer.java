package TeamSchedule.domain;

import TeamSchedule.service.Status;

/**
 * 设计师
 */
public class Designer extends Programmer {
    //奖金
    private double bonus;
    private Equipment printer;

    public Designer() {
    }

    public Designer(int numOfPosition, int id, String name, int age, double salary, Status status, Equipment equipment, double bonus) {
        super(numOfPosition, id, name, age, salary, status, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t\t" + getEquipment().getDescription();
    }

    @Override
    public String getDetailsForTeam() {
        return this.getTID() + "/" + this.getId() + "\t\t" + this.getName() + "\t" + this.getAge() + "\t\t" + this.getSalary() + "\t\t设计师";
    }

}
