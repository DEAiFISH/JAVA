import java.util.Arrays;

public class 数组填充 {
    public static void main(String[] arg){
        int a[] = new int[100];
        Arrays.fill(a,6);
        int i;
        for(i = 0;i < 100;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        Arrays.fill(a,0,9,7); //从fromindex（包含）到toindex（不包含）中的元素全部替换
        for(i = 0;i < 100;i++){
            System.out.print(a[i] + " ");
        }
    }
}
