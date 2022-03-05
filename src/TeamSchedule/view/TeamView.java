package TeamSchedule.view;

import TeamSchedule.domain.*;
import TeamSchedule.service.*;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    TeamView() {
    }

    public void enterMainMenu() {
        char menu = '0';
        listAllEmployees();

        do {
            if (menu != '1') {
                System.out.println("\n1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)： _\n");
            } else {
                listAllEmployees();
                System.out.println("\n1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)： _\n");
            }
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    this.getTeam();
                    break;
                case '2':
                    this.addMember();
                    break;
                case '3':
                    this.deleteMember();
                    break;
                case '4':
                    System.out.println("是否要退出。。。（Y/N）\n");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        System.exit(1);
                    }
            }
        } while (true);
    }

    /**
     * 打印所有员工列表
     */
    private void listAllEmployees() {
        System.out.println("\"-------------------------------开发团队调度软件--------------------------------\\n\"");
        System.out.println("ID\t姓名\t\t年龄\t\t工资\t\t\t职位\t\t状态\t\t奖金\t\t\t股票\t\t领用设备");
        Employee[] employees = listSvc.getAllEmloyees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    /**
     * 获取团队成员列表
     *
     * @return
     */
    private boolean getTeam() {
        System.out.println("--------------------团队成员列表---------------------");
        Programmer[] employees = teamSvc.getTeam();
        try {
            if (employees.length == 0) {
                throw new TeamException("开发团队目前没有成员!");
            }

            System.out.println("TID/ID\t姓名\t\t年龄\t\t工资\t\t\t职位");
            for (Programmer employee : employees) {
                System.out.println(employee.getDetailsForTeam());
            }
            System.out.println("-----------------------------------------------------");
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("-----------------------------------------------------");
            return false;
        }
    }

    /**
     * 添加指定队员
     */
    private void addMember() {
        listAllEmployees();
        System.out.println("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        Employee employee;
        try {
            employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功。");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        TSUtility.readReturn();
    }

    /**
     * 删除指定队员
     */
    private void deleteMember() {
        if (getTeam()) {

            System.out.println("请输入要删除队员的TID：");
            int TID = TSUtility.readInt();

            System.out.print("确认是否删除(Y/N)：");
            char delOrNot = TSUtility.readConfirmSelection();

            if (delOrNot == 'Y') {
                try {
                    teamSvc.removeMember(TID);
                    System.out.println("删除成功。");
                } catch (TeamException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        TSUtility.readReturn();
    }


    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}
