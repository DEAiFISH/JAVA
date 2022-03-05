import java.util.Scanner;

public class 判断是否为素数 {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int n = scan.nextInt();
        int i;
        for(i = 2;i < n / 2;i++){
            if(n % i == 0){
                break;
            }
        }
        if(i >= n / 2){
            System.out.println(n + "为素数");
        }
        else{
            System.out.println(n + "不为素数");
        }
    }
}
