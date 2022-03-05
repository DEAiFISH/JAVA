package TeamSchedule.service;

import TeamSchedule.domain.*;

import static TeamSchedule.service.Data.*;


/**
 * 负责将Data中的数据封装到employee[]数组中
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {

            //获取员工类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);

            //获取Employee基本类型
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;

            switch (type) {
                case EMPLOYEE:

                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);

                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);

                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);

                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
            }
        }
    }

    /**
     * 获取所有员工
     *
     * @return 员工数组
     */
    public Employee[] getAllEmloyees() {
        return employees;
    }

    /**
     * 获取指定ID的员工
     *
     * @param id
     * @return employee
     * @throws TeamException
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工");
    }

    /**
     * 获取指定index上的员工的设备
     *
     * @param index
     * @return
     */
    private Equipment createEquipment(int index) {

        int type = Integer.parseInt(EQUIPMENTS[index][0]);

        switch (type) {
            case PC://21
                return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
            case NOTEBOOK:
                return new NoteBook(EQUIPMENTS[index][1], Double.parseDouble(EQUIPMENTS[index][2]));
            case PRINTER:
                return new Printer(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
        }
        return null;
    }

    public Employee[] getEmployee() {
        return employees;
    }

    public void setEmployee(Employee[] employees) {
        this.employees = employees;
    }

}
