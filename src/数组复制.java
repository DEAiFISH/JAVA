import java.util.Arrays;

public class 数组复制 {
    public static void main(String[] arg){
        int a[] = {12,34,2,34,5,423,3,95};
        System.out.println("复制前的数组是：");
        int i;
        for(i = 0;i < a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int new_a[] = Arrays.copyOf(a,a.length);
        System.out.println("复制后的数组是：");
        for(i = 0;i < a.length;i++){
            System.out.print(new_a[i] + " ");
        }
        int n_a[] = Arrays.copyOfRange(a,0,3); // 不包括下标为3的元素
        System.out.println("复制后的数组是：");
        for(i = 0;i < 3;i++){
            System.out.print(new_a[i] + " ");
        }
    }
}
