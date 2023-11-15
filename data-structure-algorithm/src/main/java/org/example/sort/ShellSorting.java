package org.example.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author: ht
 * @date: 2022/10/14 21:28
 */
public class ShellSorting {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        arr = shellSorting(arr);

        Arrays.stream(arr).forEach(System.out::print);
    }

    public static int[] shellSorting(int[] arr) {
        int gap = arr.length / 2;

        while (gap > 0) {
            for (int i = 0; i < gap; i++) {
                for (int j = 0; j < arr.length / gap; j++) {
                    if (arr[i+j*gap] > arr[i+(j+1)*gap]) {
                        arr = swap(arr,i+j*gap , i+(j+1)*gap);
                    }
                }
            }
            gap /= 2;
        }

        return arr;
    }

    private static int[] swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return arr;
    }
}

