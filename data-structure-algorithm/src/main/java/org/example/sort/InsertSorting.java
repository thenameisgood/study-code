package org.example.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 *
 * @author: ht
 * @date: 2022/10/14 21:04
 */
public class InsertSorting {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1, -1, 89};

        int max = 100000;
        int[] arr = new int[max];

        for (int i = 0; i < max; i++) {
            arr[i] = (int) (Math.random() * max);
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()));

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] <= arr[j]) {
                    arr = swap(arr, i, j);
                }
            }
//            System.out.print("第"+i+"轮");
//            for (int i1 : arr) {
//                System.out.print(" ");
//                System.out.print(i1);
//            }
//            System.out.println();
        }

//        Arrays.stream(arr).forEach(System.out::println);

        System.out.println(simpleDateFormat.format(new Date()));
    }

    private static int[] swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return arr;
    }
}

