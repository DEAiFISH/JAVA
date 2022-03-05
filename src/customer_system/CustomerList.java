package customer_system;


public class CustomerList {
    private Customer[] customers;
    int total;

    /**
     * 给客户列表初始化
     * @param totalCustomer 可容纳的客户数
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * 在客户列表中添加指定的客户
     * @param customer 客户信息
     * @return ture ：添加成功   false ：添加失败
     */
    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false;
        }
        customers[total++] = customer;
        return true;
    }

    /**
     *在客户列表中修改指定的客户
     * @param index 客户序号
     * @param customer 客户信息
     * @return ture ：添加成功   false ：添加失败
     */
    public boolean replaceCustomer(int index, Customer customer){
        if(index < 0 || index > total){
            return false;
        }
        customers[index] = customer;
        return true;
    }

    /**
     * 在客户列表中删除指定的客户
     * @param index 客户序号
     * @return ture ：添加成功   false ：添加失败
     */
    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }
        for(int i = index;i < total - 1;i++){
            customers[i] = customers[i + 1];
        }
        customers[--total] = null;
        return true;
    }

    /**
     * 获取所有的客户的信息
     * @return 客户信息
     */
    public Customer[] getAllCustomers(){
        Customer[] customers = new Customer[total];
        for(int i = 0;i < total;i++){
            customers[i] = this.customers[i];
        }
        return customers;
    }

    /**
     * 获取指定客户的信息
     * @param index 客户序号
     * @return ture :指定客户的信息  false :报错
     */
    public Customer getCustomer(int index){
        if(index > total || index < 0){
            System.out.println("未找到指定的客户！");
        }
        return customers[index];
    }

    /**
     * 获取已录入的客户数量
     * @return 数量
     */
    public int getTotal(){
        return total;
    }

}
