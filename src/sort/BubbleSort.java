package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @description 冒泡排序
 *
 * @author DEAiFISH
 * @date 2025/7/16 23:46
 */
public class BubbleSort {

    public static void main(String[] args) {
        int len = 10;
        int[] arr = new int[len];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (100 * random.nextDouble());
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("=======================");
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("没有进行交换，提前结束。共执行：" + i + "轮");
                break;
            }
            System.out.println("第" + (i + 1) + "轮：" + Arrays.toString(arr));
        }

    }

}
