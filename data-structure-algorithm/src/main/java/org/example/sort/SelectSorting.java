package org.example.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 选择排序
 *
 * @author: ht
 * @date: 2022/10/14 20:35
 */
public class SelectSorting {
    public static void main(String[] args) {
//        int[] arr = {2, 43, 3, 5, -10, 9};
        int max = 100000;
        int[] arr = new int[max];

        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * max);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr = swap(arr, i, minIndex);
            }
        }

        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    private static int[] swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return arr;
    }
}

