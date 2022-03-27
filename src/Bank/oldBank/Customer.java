package Bank.oldBank;

import java.util.Random;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;
    private int id;


    public int getid() {
        return id;
    }


    public Customer(int balance) {
        Random rand = new Random();
        id = rand.nextInt(100000) + 10000;
        setAccount(new Account(balance));
    }

    public Customer(String f, String l, int balance) {
        this(balance);
        firstName = f;
        lastName = l;
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
    public void setAccount(Account account) {
        if (account.getBalance() >= Bank.getMinBalance()) {
            System.out.println("创建成功！");
            this.account = account;
            return;
        }
        System.out.println("初始余额不足，创建失败");
    }
}
