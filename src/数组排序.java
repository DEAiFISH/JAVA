import java.util.Arrays;

public class 数组排序 {
    public static void main(String[] arg){
        int a[] = {12,34,2,34,5,423,3,95};
        System.out.println("原数组：");
        int i;
        for(i = 0;i < a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        Arrays.sort(a);
        System.out.println("排序后：");
        for(i = 0;i < a.length;i++){
            System.out.print(a[i] + " ");
        }
    }
}
