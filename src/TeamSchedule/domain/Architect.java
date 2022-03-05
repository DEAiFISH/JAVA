package TeamSchedule.domain;

/**
 * 架构师
 */
public class Architect extends Designer{
    //股票
    private int stock;

    public Architect(){
    }
    public Architect(int id,String name,int age, double salary,Equipment equipment,double bonus,int stock){
        super(id,name,age,salary,equipment,bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString(){
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t\t" + stock + "\t" + getEquipment().getDescription();
    }

    @Override
    public String getDetailsForTeam(){
        return this.getTID() + "/" + this.getId() + "\t\t" + this.getName() + "\t" + this.getAge() + "\t\t" + this.getSalary() + "\t\t架构师";
    }

}
