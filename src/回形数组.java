import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author qingyuan
 */
public class 回形数组 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("需要打印几行的回型矩阵: ");
        int len = 0;
        try{
            len = scan.nextInt();
        }catch(InputMismatchException e){
            System.out.println("请输入数字！！！");
            main(null);
            System.exit(1);
        }
        int[][] arr = new int[len][len];
        try{
            Set(arr);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            main(null);
            System.exit(1);
        }
        Print(arr);
    }

    // 向上抛出异常 throws
    public static void Set(int[][] arr) throws RuntimeException{
        int len = arr.length;
        //手动抛出异常 throw
        if (len == 0) {
            throw new RuntimeException("长度不能为0！！！");
        }
        int s = len * len;
        int q;
        int k = 1;
        int p = (int)(1.0 * len / 2 + 0.5);
        for(q = 0;q < p && k <= s;q++){
            int m;
            for(m = q;m < len - q;m++){
                arr[q][m] = k++;
            }
            for(m = q + 1;m < len - q;m++){
                arr[m][len - q - 1] = k++;
            }
            for(m = len - q - 2;m >= q;m--){
                arr[len - q - 1][m] = k++;
            }
            for(m = len - q - 2;m > q;m--){
                arr[m][q] = k++;
            }
        }
    }

    public static void Print(int[][] arr){
        int len = arr.length;
        for (int[] ints : arr) {
            for (int b = 0; b < len; b++) {
                System.out.print(ints[b] + "\t");
            }
            System.out.println();
        }
    }
}
