package TeamSchedule.Test;

import TeamSchedule.domain.Employee;
import TeamSchedule.service.*;

/**
 * NameListService 的测试程序
 */
public class NameListServiceTest {
    public static void main(String[] args) {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmloyees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println();

        int id = 41;

        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
