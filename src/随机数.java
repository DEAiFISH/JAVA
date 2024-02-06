import java.util.HashSet;

public class 随机数 {
    public static void main(String[] args) {

        test2();
    }

    private static void test1() {
        int[] arr = new int[7];
        int i;
        for (i = 0; i < 7; i++) {

            //随机数 法一：
//            Random t = new Random(20);
//            arr[i] = t.nextInt(20);
            // 法二
            arr[i] = (int) (Math.random() * 7);

            int j;
            for (j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    arr[i] = (int) (Math.random() * 7);
                    j = -1;
                }
            }


            System.out.println(arr[i]);
        }
    }

    private static void test2() {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 10);
            while (set.contains(num)) {
                num = (int) (Math.random() * 10);
            }
            set.add(num);
            System.out.print(num + " ");
        }

    }
}
