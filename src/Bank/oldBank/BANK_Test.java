package Bank.oldBank;

public class BANK_Test {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        System.out.println(bank.getNumberOfCustomer());
        bank.addCustomer("Jane", "Smith", 100);
        bank.addCustomer("Jane", "Smith", 2020);
        System.out.println(bank.getNumberOfCustomer());
        Customer cust = bank.getCustomer();
        System.out.println(cust.getFirstName() + " " + cust.getAccount().getBalance());
        System.out.println(Bank.getDepositRate());
    }
}
