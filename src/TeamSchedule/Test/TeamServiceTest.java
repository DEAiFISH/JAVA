package TeamSchedule.Test;

import TeamSchedule.domain.Programmer;
import TeamSchedule.service.*;


public class TeamServiceTest {
    public static void main(String[] args) throws TeamException {
        TeamService teamService = new TeamService();
        System.out.println(teamService.getTotal());
        NameListService nameListService = new NameListService();
        teamService.addMember(nameListService.getEmployee(2));
        teamService.addMember(nameListService.getEmployee(3));
        teamService.addMember(nameListService.getEmployee(4));
        Programmer[] t = teamService.getTeam();
        for (Programmer i : t) {
            System.out.println(i);
        }
        System.out.println();
        teamService.removeMember(1);
        t = teamService.getTeam();
        for (Programmer i : t) {
            System.out.println(i);
        }
    }
}
