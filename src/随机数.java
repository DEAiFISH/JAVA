import java.util.Random;

public class 随机数 {
    public static void main(String[] args){
        int[] arr = new int[7];
        int i;
        for(i = 0;i < 7;i++) {

            //随机数 法一：
//            Random t = new Random(20);
//            arr[i] = t.nextInt(20);、
            // 法二：
              arr[i] = (int) (Math.random() * 7);

            int j;
            for(j = 0;j < i;j++){
                if(arr[j] == arr[i]){
                    arr[i] = (int) (Math.random() * 7);
                    j = -1;
                }
            }


            System.out.println(arr[i]);
        }
    }
}
