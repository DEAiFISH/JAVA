package TeamSchedule.service;


import TeamSchedule.domain.Architect;
import TeamSchedule.domain.Designer;
import TeamSchedule.domain.Employee;
import TeamSchedule.domain.Programmer;

import java.util.ArrayList;

public class TeamService {
    //用来为开发团队新增成员自动生成团队中的唯一ID
    private static int counter = 1;
    //最大团队成员数
    private final int MAX_MEMBER = 5;
    //用来保存团队中的各成员对象
    private ArrayList<Programmer> teamListService = new ArrayList<>();
    //记录团队的实际人数

    private static TeamService instance = null;

    private TeamService(){
        initialize();
    }

    public static TeamService getInstance(){
        if(instance == null){
            synchronized (TeamService.class){
                if(instance == null){
                    instance = new TeamService();
                }
            }
        }
        return instance;
    }


    public int getCounter() {
        return counter;
    }

    public int getTotal() {
        return teamListService.size();
    }


    /**
     * 获取team中的所有成员
     *
     * @return
     */
    public ArrayList getTeam() {
        return teamListService;
    }


    /**
     * 将指定员工添加到开发团队中
     *
     * @param employee
     * @throws TeamException
     */
    public void addMember(Employee employee) throws TeamException {
        if (teamListService.size() == MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加\n");
        }
        if (!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加\n");
        }
        if (isExist(employee)) {
            throw new TeamException("该成员已加入开发团队\n");
        }

        Programmer programmer = (Programmer) employee;

        switch (programmer.getStatus()) {
            case BUSY -> throw new TeamException("该成员已是某团队的队员\n");
            case VOCATION -> throw new TeamException("该成员正在休假\n");
        }

        //获取已有的架构师，设计师，程序员的人数
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (Employee e : teamListService) {
            if (e instanceof Architect) {
                numOfArch++;
            } else if (e instanceof Designer) {
                numOfDes++;
            } else {
                numOfPro++;
            }
        }

        if (programmer instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中最多只能有一名架构师");
            }
        } else if (programmer instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中最多只能有两名设计师");
            }
        } else {
            if (numOfPro >= 3) {
                throw new TeamException("团队中最多只能有三名程序员");
            }
        }

        //将programmeri添加到团队中
        teamListService.add(programmer);
        programmer.setStatus(Status.BUSY);
        programmer.setTID(counter++);

    }

    /**
     * 判断该成员是否已经加入团队
     *
     * @param employee
     * @return
     */
    private boolean isExist(Employee employee) {
        for (Employee e : teamListService) {
            if (e.getId() == employee.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除团队中指定TID的队员
     *
     * @param ID
     * @throws TeamException
     */
    public void removeMember(int ID) throws TeamException {
        int i;
        for (i = 0; i < teamListService.size(); i++) {
            Programmer programmer = teamListService.get(i);
            if(programmer.getId() == ID){
                programmer.setStatus(Status.FREE);
                teamListService.remove(i);
                return;
            }
        }
        if (i == teamListService.size()) {
            throw new TeamException("团队中没有该成员，删除失败");
        }
    }

    private void initialize(){
        NameListService nameListService = NameListService.getInstance();
        ArrayList<Employee> employees = nameListService.getEmployee();
        for (Employee employee: employees) {
            if(employee instanceof Programmer){
                Programmer programmer = (Programmer) employee;
                if(programmer.getStatus() == Status.BUSY){
                    programmer.setTID(counter++);
                    teamListService.add(programmer);

                }
            }
        }
    }
}
