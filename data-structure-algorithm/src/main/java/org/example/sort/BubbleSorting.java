package org.example.sort;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * 冒泡排序
 *
 * @author: ht
 * @date: 2022/10/14 19:47
 */
public class BubbleSorting {

    public static void main(String[] args) {
        int[] arr = {4, 1, 6, 7, 100, -1, 5};
//        int[] arr = {1,2,3,4,5};

        //表示是否进行过交换
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    arr = swap(arr, j, j + 1);
                    System.out.println("交换了");
                }
            }
            if (!flag) {
                break;
            }
        }

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static int[] swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return arr;
    }

}

