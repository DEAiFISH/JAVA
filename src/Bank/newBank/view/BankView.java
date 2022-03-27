package Bank.newBank.view;

import Bank.newBank.domain.Bank;
import Bank.newBank.domain.Customer;
import Bank.newBank.service.cacheDate;

import java.util.Scanner;

public class BankView {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        cacheDate cacheDate = new cacheDate();
        cacheDate.downDate(bank);
        view v = new view();
        v.view(bank);
    }
}

class view {

    public void view(Bank bank) {
        int k = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            cacheDate cacheDate = new cacheDate();
            Print();
            k = scanner.nextInt();
            showCustomers(bank);
            switch (k) {
                case 1:
                    bank.addCustomer();
                    break;
                case 2:
                    bank.deleteCustomer();
                    break;
                case 3:
                    bank.updateCustomer();
                    break;
                case 4:
                    bank.getCustomer();
                    break;
                case 5:
                    cacheDate.upDate(bank);
                    System.out.println("程序结束。。。");
                    System.exit(1);
                default:
                    System.out.println("请重新输入。。。\n");
            }
        }

    }

    public void Print() {
        System.out.println("1·添加客户");
        System.out.println("2·删除客户");
        System.out.println("3·修改客户");
        System.out.println("4·查询客户");
        System.out.println("5·退出");
    }

    public void showCustomers(Bank bank) {
        for (Customer customer : bank.getCustomersList()) {
            System.out.println(customer);
        }
    }
}
