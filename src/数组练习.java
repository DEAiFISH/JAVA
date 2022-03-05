import java.util.Scanner;

public class 数组练习 {
    public static void main(String[] arg){
        //联系电话
        int[] a = {1,8,4,5,7,9,0,3};
        int[] index = {0,1,0,0,0,2,3,4,5,6,7};
        String tel = "";
        int i;
        for(i = 0;i < index.length;i++){
            tel += a[index[i]];
        }
        System.out.printf("联系方式为：" + tel);




        //成绩统计
//        Scanner scan = new Scanner(System.in);
//        System.out.print("请输入学生人数：");
//        int n = scan.nextInt();
//        int[]score = new int[n];
//        int i;
//        for(i = 0;i < n;i++){
//            System.out.print("请输入第" + (i+1) + "个学生的成绩：");
//            score[i] = scan.nextInt();
//        }
//        int max_score = score[0];
//        for(i = 1;i < n;i++){
//            if(score[i] > max_score){
//                max_score = score[i];
//            }
//        }
//        System.out.println("最高分是：" + max_score);
//        for(i = 0;i < n;i++){
//            System.out.print("Student " + i+1 + " score is " + score[i] + ", grade is ");
//            switch ((max_score - score[i]) / 100){
//                case 0:System.out.println("A");break;
//                case 1: System.out.println("B");break;
//                case 2: System.out.println("C");break;
//                default: System.out.println("D");
//            }
//        }
    }
}
