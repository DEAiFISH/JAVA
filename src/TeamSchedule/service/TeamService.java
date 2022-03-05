package TeamSchedule.service;

import TeamSchedule.domain.*;

public class TeamService {
    //用来为开发团队新增成员自动生成团队中的唯一ID
    private static int counter = 1;
    //最大团队成员数
    private final int MAX_MEMBER = 5;
    //用来保存团队中的各成员对象
    private Programmer[] team = new Programmer[MAX_MEMBER];
    //记录团队的实际人数
    private int total = 0;

    public int getCounter() {
        return counter;
    }

    public int getTotal() {
        return total;
    }


    /**
     * 获取team中的所有成员
     *
     * @return
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }


    /**
     * 将指定员工添加到开发团队中
     *
     * @param employee
     * @throws TeamException
     */
    public void addMember(Employee employee) throws TeamException {
        if (total == MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加\n");
        }
        if (!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加\n");
        }
        if (isExist(employee)) {
            throw new TeamException("该成员已加入开发团队\n");
        }

        Programmer programmer = (Programmer) employee;
//        if ("BUSH".equals(programmer.getStatus())) {
//            throw new TeamException("该成员已是某团队的队员\n");
//        } else if ("VOCATION".equals(programmer.getStatus())) {
//            throw new TeamException("该成员正在休假\n");
//        }
        switch (programmer.getStatus()){
            case BUSY -> throw new TeamException("该成员已是某团队的队员\n");
            case VOCATION -> throw new TeamException("该成员正在休假\n");
        }

        //获取已有的架构师，设计师，程序员的人数
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else {
                numOfPro++;
            }
        }

        if (programmer instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中最多只能有一名架构师");
            }
        }
        if (programmer instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中最多只能有两名设计师");
            }
        }
        if (programmer instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中最多只能有三名程序员");
            }
        }

        //将programmeri添加到团队中
        team[total++] = programmer;
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
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == employee.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 删除团队中指定TID的队员
     *
     * @param TID
     * @throws TeamException
     */
    public void removeMember(int TID) throws TeamException {
        int i;
        for (i = 0; i < total; i++) {
            if (team[i].getTID() == TID) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i == total) {
            throw new TeamException("团队中没有该成员，删除失败");
        }
        for (int j = i; j < total - 1; j++) {
            team[j] = team[j + 1];
        }
        team[--total] = null;
    }
}
