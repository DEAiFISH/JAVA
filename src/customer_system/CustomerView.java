package customer_system;


public class CustomerView {
    private CustomerList customerList = new CustomerList(100);

    public static void main(String[] args){

        CustomerView cView = new CustomerView();
        cView.enterMainMenu();
    }

    public CustomerView(){
        Customer customer = new Customer("张三", '男', 30, "0100-56253825",
                "abc@email.com");
        customerList.addCustomer(customer);
    }

    public void enterMainMenu(){
        boolean loopFlag = true;
        do {
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("请选择(1-5)：");

            char key = CMUtility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = CMUtility.readConfirmSelection();
                    if (yn == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        } while (loopFlag);
    }

    /**
     * 添加客户
     */
    private void addNewCustomer(){
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(20);

        Customer customer = new Customer(name,gender,age,phone,email);
        boolean flag = customerList.addCustomer(customer);

        if(flag){
            System.out.println("---------------------添加完成---------------------");
        }
        else{
            System.out.println("----------------记录已满,无法添加-----------------");
        }
    }

    /**
     * 修改客户
     */
    private void modifyCustomer(){
        System.out.println("---------------------修改客户---------------------");

        int index = 0;
        Customer customer = null;
        for (;;) {
            System.out.print("请选择待修改客户编号(1 -- " + customerList.getTotal() + ",-1退出)：");
            index = CMUtility.readInt();
            if (index == -1) {
                return;
            }

            customer = customerList.getCustomer(--index);
            if (customer == null) {
                System.out.println("无法找到指定客户！");
            }
            else{
                break;
            }
        }

        System.out.println("不修改可直接敲回车键。");
        System.out.print("姓名(" + customer.getName() + ")：");
        String name = CMUtility.readString(4, customer.getName());

        System.out.print("性别(" + customer.getGender() + ")：");
        char gender = CMUtility.readChar(customer.getGender());


        System.out.print("年龄(" + customer.getAge() + ")：");
        int age = CMUtility.readInt(customer.getAge());

        System.out.print("电话(" + customer.getPhone() + ")：");
        String phone = CMUtility.readString(15, customer.getPhone());

        System.out.print("邮箱(" + customer.getEmail() + ")：");
        String email = CMUtility.readString(15, customer.getEmail());

        customer = new Customer(name, gender, age, phone, email);

        boolean flag = customerList.replaceCustomer(index, customer);
        if (flag) {
            System.out
                    .println("---------------------修改完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,修改失败--------------");
        }
    }

    /**
     * 删除客户
     */
    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        int index = 0;

        do{
            System.out.print("请选择待修改客户编号(1 -- " + customerList.getTotal() + ",-1退出)：");

            index = CMUtility.readInt();
            if(index == -1){
                return;
            }
            Customer customer = customerList.getCustomer(--index);
            if(customer == null){
                System.out.println("无法找到指定客户！");
            }
            else {
                break;
            }
        }while (true);

        System.out.print("确认是否删除(Y/N)：");
        char yn = CMUtility.readConfirmSelection();
        if (yn == 'N') {
            return;
        }

        boolean flag = customerList.deleteCustomer(index);
        if (flag) {
            System.out
                    .println("---------------------删除完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,删除失败--------------");
        }
    }

    /**
     * 客户列表
     */
    private void listAllCustomers(){
        System.out.println("---------------------------客户列表---------------------------");

        if(customerList.getTotal() == 0){
            System.out.println("没有客户记录！");
        }

        Customer[] customers = customerList.getAllCustomers();
        System.out.println("编号\t\t姓名\t\t\t性别\t\t\t年龄\t\t\t\t电话\t\t\t\t邮箱");
        for(int i = 0;i < customerList.getTotal();i++){
            System.out.println(i + 1 +
                    "\t\t" + customers[i].getName() +
                    "\t\t\t" + customers[i].getGender() +
                    "\t\t\t" + customers[i].getAge() +
                    "\t\t\t\t" + customers[i].getPhone() +
                    "\t\t\t\t" + customers[i].getEmail());
        }
    }

}
