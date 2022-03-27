package Bank.newBank.domain;

import Bank.oldBank.Account;

public class Customer {
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String firstName;
    private String lastName;
    private Account account;
    private static int Id = 10001;
    private int id;


    public int getID(){
        return Id;
    }
    public int getId() {
        return id;
    }


    public Customer(double balance) {
        boolean flag = setAccount(new Account(balance));
        if (flag) {
            id = Id++;
        }
    }

    public Customer(String f, String l, double balance) {
        this(balance);
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    //初始化余额
    public boolean setAccount(Account account) {
        if (account.getBalance() < Bank.getMinBalance()) {
            System.out.println("初始余额不足，创建失败");
            return false;
        } else {
            this.account = account;
            return true;
        }
    }

    @Override
    public String toString() {
        return "id= " + id +
                "，Name= " + firstName + lastName;
    }

}
