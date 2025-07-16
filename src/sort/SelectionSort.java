package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @description 选择排序
 *
 * @author DEAiFISH
 * @date 2025/7/16 23:46
 */
public class SelectionSort {

    public static void main(String[] args) {
        int len = 10;
        int[] arr = new int[len];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (100 * random.nextDouble());
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("=======================");
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = arr[i];
            int l = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    l = j;
                }
            }
            arr[l] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

}
