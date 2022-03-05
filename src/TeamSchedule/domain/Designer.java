package TeamSchedule.domain;

/**
 * 设计师
 */
public class Designer extends Programmer{
    //奖金
    private double bonus;

    public Designer() {
    }
    public Designer(int id,String name,int age, double salary,Equipment equipment,double bonus){
        super(id,name,age,salary,equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    @Override
    public String toString(){
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t\t" + getEquipment().getDescription();
    }

    @Override
    public String getDetailsForTeam(){
        return this.getTID() + "/" + this.getId() + "\t\t" + this.getName() + "\t" + this.getAge() + "\t\t" + this.getSalary() + "\t\t设计师";
    }

}
