package TeamSchedule.service;


import TeamSchedule.domain.PC;
import TeamSchedule.domain.*;

import java.io.*;
import java.util.ArrayList;

import static TeamSchedule.service.Data.*;


public class NameListService {
    /**
     * 所有员工列表
     */
    private ArrayList<Employee> employees = new ArrayList<>();

    private static NameListService instance = null;

    public static NameListService getInstance() {
        if (instance == null) {
            synchronized (NameListService.class) {
                if (instance == null) {
                    instance = new NameListService();
                }
            }
        }
        return instance;
    }


    private NameListService() {
        getFileDate();
    }

    /**
     * 获取所有员工
     *
     * @return 员工数组
     */
    public ArrayList<Employee> getAllEmloyees() {
        return employees;
    }

    /**
     * 获取指定ID的员工
     */
    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                return employee;
            }
        }
        throw new TeamException("找不到指定员工");
    }

    /**
     * 获取员工的设备
     */
    private Equipment createEquipment(String[] equipments) {
        int type = Integer.parseInt(equipments[0]);
        switch (type) {
            case PC://21
                return new PC(Integer.parseInt(equipments[0]), equipments[1], equipments[2]);
            case NOTEBOOK://22
                return new NoteBook(Integer.parseInt(equipments[0]), equipments[1], Double.parseDouble(equipments[2]));
            case PRINTER://23
                return new Printer(Integer.parseInt(equipments[0]), equipments[1], equipments[2]);
        }
        throw new RuntimeException("设备信息异常:" + equipments[0]);
    }

    //获取所有员工列表
    public ArrayList<Employee> getEmployee() {
        return employees;
    }


    //添加新员工
    public void setEmployee(Employee employee) {
        this.employees.add(employee);
    }


    /**
     * 从本地文件获取数据
     */
    public void getFileDate() {
        BufferedReader brEmployees = null;
        BufferedReader brEquipments = null;
        try {
            brEmployees = new BufferedReader(new FileReader("src/TeamSchedule/service/Date/employeesDate.txt"));
            brEquipments = new BufferedReader(new FileReader("src/TeamSchedule/service/Date/equipmentsDate.txt"));

            //用来暂时储存员工信息
            String emp;
            //用来暂时储存设备信息
            String equ;

            while (true) {
                if ((emp = brEmployees.readLine()) != null) {
                    equ = brEquipments.readLine();

                    String[] emps = emp.split(",");
                    String[] equs = equ.split(",");
                    //获取员工类型
                    int type = Integer.parseInt(emps[0]);

                    //获取Employee基本类型
                    int id = Integer.parseInt(emps[1]);
                    String name = emps[2];
                    int age = Integer.parseInt(emps[3]);
                    double salary = Double.parseDouble(emps[4]);
                    Equipment equipment;
                    Status status;
                    double bonus;
                    int stock;

                    switch (type) {
                        case EMPLOYEE:
                            employees.add(new Employee(type, id, name, age, salary));
                            break;
                        case PROGRAMMER:
                            equipment = createEquipment(equs);
                            status = Status.valueOf(emps[5]);
                            employees.add(new Programmer(type, id, name, age, salary, status, equipment));
                            break;
                        case DESIGNER:
                            equipment = createEquipment(equs);
                            status = Status.valueOf(emps[5]);
                            bonus = Double.parseDouble(emps[6]);
                            employees.add(new Designer(type, id, name, age, salary, status, equipment, bonus));
                            break;
                        case ARCHITECT:
                            equipment = createEquipment(equs);
                            status = Status.valueOf(emps[5]);
                            bonus = Double.parseDouble(emps[6]);
                            stock = Integer.parseInt(emps[7]);
                            employees.add(new Architect(type, id, name, age, salary, status, equipment, bonus, stock));
                    }
                } else {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (brEmployees != null) {
                try {
                    brEmployees.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (brEquipments != null) {
                    try {
                        brEquipments.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * 将内存中的数据保存到本地文件中
     */
    public void saveToLocal() {
        BufferedWriter bwEmployees = null;
        BufferedWriter bwEquipments = null;
        try {
            bwEmployees = new BufferedWriter(new FileWriter("src/TeamSchedule/service/Date/employeesDate.txt"));
            bwEquipments = new BufferedWriter(new FileWriter("src/TeamSchedule/service/Date/equipmentsDate.txt"));

            for (Employee employee : instance.employees) {
                int type = employee.getNumOfPosition();
                int id = employee.getId();
                String name = employee.getName();
                int age = employee.getAge();
                double salary = employee.getSalary();

                Status status;
                double bonus;
                int stock;
                Equipment equipment = null;


                switch (type) {
                    case EMPLOYEE:
                        bwEmployees.write(type + "," + id + "," + name + "," + age + "," + salary + "\n");
                        bwEquipments.write("\n");
                        break;
                    case PROGRAMMER:
                        status = ((Programmer) employee).getStatus();
                        equipment = ((Programmer) employee).getEquipment();
                        bwEmployees.write(type + "," + id + "," + name + "," + age + "," + salary + "," + status + "\n");
                        bwEquipments.write(equipment.getDescribe() + "\n");
                        break;
                    case DESIGNER:
                        status = ((Designer) employee).getStatus();
                        bonus = ((Designer) employee).getBonus();
                        equipment = ((Programmer) employee).getEquipment();
                        bwEmployees.write(type + "," + id + "," + name + "," + age + "," + salary + "," + status + "," + bonus + "\n");
                        bwEquipments.write(equipment.getDescribe() + "\n");
                        break;
                    case ARCHITECT:
                        status = ((Architect) employee).getStatus();
                        bonus = ((Architect) employee).getBonus();
                        stock = ((Architect) employee).getStock();
                        equipment = ((Programmer) employee).getEquipment();
                        bwEmployees.write(type + "," + id + "," + name + "," + age + "," + salary + "," + status + "," + bonus + "," + stock + "\n");
                        bwEquipments.write(equipment.getDescribe() + "\n");
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (bwEmployees != null) {
                try {
                    bwEmployees.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (bwEmployees != null) {
                    try {
                        bwEquipments.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println("保存成功！");
    }

}


