import java.util.Scanner;

public class 阶乘计算 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int sum[] = new int[3000];
        sum[0] = 1;
        for (int i = 1; i <= m; i++) {
            int n = NumberOfDigits(sum);
            for (int j = 0; j <= n; j++) {
                sum[j] *= i;
            }
            sum = jw(sum,n);
        }
        for (int i = NumberOfDigits(sum); i >= 0; i--) {
            System.out.print(sum[i]);
        }
    }

    public static int[] jw(int[] a,int n) {
        for (int i = 0; i <= n; i++) {
            if (a[i] > 9) {
                int t = a[i] % 100;
                a[i + 1] += (a[i] - t) / 100;
                a[i] = t;
            }
        }
        return a;
    }

    public static int NumberOfDigits(int[] a) {
        int k = a.length - 1;
        while (a[k] == 0) {
            k--;
        }
        return k;
    }
}
