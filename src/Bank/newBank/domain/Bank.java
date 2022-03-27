package Bank.newBank.domain;

import Bank.newBank.service.cacheDate;

import java.util.*;

public class Bank {

    private ArrayList<Customer> customers = new ArrayList();

    private static final int minBalance = 1000;


    //懒汉式
    private static Bank instance = null;

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

    public static int getMinBalance() {
        return minBalance;
    }

    public ArrayList<Customer> getCustomersList() {
        return customers;
    }

    public void setCustomersList(Customer customer) {
        this.customers.add(customer);
    }

    //添加客户
    public void addCustomer() {
        cacheDate cacheDate = new cacheDate();
        System.out.println("请输入要录入用户的信息（FirstName，LastName,Balance）");
        Scanner scanner = new Scanner(System.in);
        String FirstName = scanner.nextLine();
        String LastName = scanner.nextLine();
        double balance = scanner.nextDouble();


        int size = customers.size();
        for (int i = 0; i < size; i++) {
            if (FirstName.equals(customers.get(i).getFirstName()) && LastName.equals(customers.get(i).getLastName())) {
                System.out.println("该用户已录入...");
                return;
            }
        }

        Customer customer = new Customer(FirstName, LastName, balance);
        if (customer.getAccount() == null) {
            return;
        }

        customers.add(customer);
        cacheDate.setSaveFlag(true);
    }

    public void deleteCustomer() {
        System.out.println("请输入想要删除用户的ID");
        int id = ReadID();
        if(id == -1){
            return;
        }
        int index = id - 10000 - 1;
        customers.remove(index);

        System.out.println("删除成功...");
        cacheDate cacheDate = new cacheDate();
        cacheDate.setSaveFlag(true);

    }

    public void updateCustomer(){
        System.out.println("请输入你想要修改用户的ID：");
        int id = ReadID();
        if(id == -1){
            return;
        }
        int index = id - 10000 - 1;
        System.out.println("请输入修改后的FirstName和LastName");
        Scanner scanner = new Scanner(System.in);
        String FirstName = scanner.nextLine();
        String LastName = scanner.nextLine();
        customers.get(index).setFirstName(FirstName);
        customers.get(index).setLastName(LastName);

        System.out.println("修改成功");
    }


    //获取指定客户的信息
    public void getCustomer() {
        System.out.println("请输入要查询用户的ID：");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        for (Customer c : customers) {
            if (c.getId() == id) {
                System.out.println(c.getAccount());
                return;
            }
        }

        System.out.println("该用户还未录入\n");

    }

    public int ReadID(){
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        if (id < 10000 || id > customers.get(0).getID()) {
            System.out.println("没有该用户....");
            return -1;
        }
        return id;
    }
}
