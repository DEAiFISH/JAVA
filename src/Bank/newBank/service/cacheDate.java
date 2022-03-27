package Bank.newBank.service;

import Bank.newBank.domain.Bank;
import Bank.newBank.domain.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;


public class cacheDate {

    private static boolean saveFlag = false;

    private static int numOfCus = 0;

    /**
     * 保存到本地文件
     */
    public void upDate(Bank bank) {
        if (isSaveFlag()) {
            System.out.println("是否保存修改...Y/N");
            Scanner scanner = new Scanner(System.in);

            boolean flag = true;
            do {
                String c = scanner.nextLine();
                c = c.toUpperCase(Locale.ROOT);
                switch (c) {
                    case "N":
                        return;
                    case "Y":
                        flag = false;
                        break;
                    default:
                        System.out.println("请输入(Y/N)");
                }
            } while (flag);
        } else {

            return;
        }
        ArrayList<Customer> customersList = bank.getCustomersList();
        BufferedWriter bw = null;
        File file = new File("src/Bank/newBank/service/Date");
        Delete(file);

        for (int i = 0; i < customersList.size(); i++) {
            try {

                Customer customer = customersList.get(i);
                String fileName = customer.getId() + "#" + customer.getFirstName() + customer.getLastName() + ".properties";
                bw = new BufferedWriter(new FileWriter("src/Bank/newBank/service/Date/" + fileName));
                bw.write("FirstName=" + customer.getFirstName());
                bw.newLine();
                bw.write("LastName=" + customer.getLastName());
                bw.newLine();
                bw.write("id=" + customer.getId());
                bw.newLine();
                bw.write("Account=" + customer.getAccount().getBalance());


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 从本地文件读取到内存
     */
    public static void downDate(Bank bank) {
        File content = new File("src/Bank/newBank/service/Date");
        File[] files = content.listFiles();
        int len = files.length;
        numOfCus = len;

        BufferedReader br = null;
        for (int i = 0; i < len; i++) {
            try {

                File file = files[i];
                Properties properties = new Properties();
                br = new BufferedReader(new FileReader("src/Bank/newBank/service/Date/" + file.getName()));
                properties.load(br);

                String FirstName = properties.getProperty("FirstName");
                String LastName = properties.getProperty("LastName");
                int id = Integer.parseInt(properties.getProperty("id"));
                double balance = Double.parseDouble(properties.getProperty("Account"));

                bank.setCustomersList(new Customer(FirstName, LastName, balance));

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean isSaveFlag() {
        return saveFlag;
    }

    public void setSaveFlag(boolean saveFlag) {
        this.saveFlag = saveFlag;
    }

    public int getNumOfCus() {
        return numOfCus;
    }

    public void setNumOfCus(int numOfCus) {
        cacheDate.numOfCus = numOfCus;
    }

    public void Delete(File file) {
        if (!file.exists()) {
            return;
        }

        File[] allFile = file.listFiles();
        for (File f : allFile) {
            f.delete();
        }
    }
}


