package org.example.sort;


import java.util.Arrays;

/**
 * 快速排序
 *
 * @author: ht
 * @date: 2022/10/14 22:20
 */
public class QuickSorting {
    public static void main(String[] args) {
        int[] arr = {2, 31, 5, 7, 23, 1, 4, 75, 53, 1, 2, 60};
        arr = quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = arr[(l + r) / 2];
        while (l < r) {
            while (arr[l] < mid) {
                l += 1;
            }
            while (arr[r] > mid) {
                r -= 1;
            }
            //如果 l >= r 说明mid的左右两侧的值已经排好了
            if (l >= r) {
                break;
            }

            arr = swap(arr, l, r);

            if (arr[l] == mid) {
                r -= 1;
            }
            if (arr[r] == mid) {
                l += 1;
            }

            if (l == r) {
                l += 1;
                r -= 1;
            }

            if (left < r) {
                quickSort(arr, left, r);
            }
            if (right > l) {
                quickSort(arr, l, right);
            }
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

