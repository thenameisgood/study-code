package org.example.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: ht
 * @date: 2022/10/15 19:28
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        int i = fibSearch(arr, 1000);
        System.out.println("搜索下标是:" + i);
    }

    public static int maxsize = 20;

    public static int[] fibonacci() {
        int[] f = new int[maxsize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxsize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        //斐波那契分割数值下标
        int k = 0;
        int mid = 0;
        //获得斐波那契数列
        int[] f = fibonacci();
        //获得斐波那契分割数值下标
        while (high > f[k] - 1) {
            k++;
        }
        //利用Java工具类Arrays 构造新数组并指向 数组 arr[]
        int[] temp = Arrays.copyOf(arr, f[k]);

        //对新构造的数组进行 元素补充
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            //由于前面部分有f[k-1]个元素  //mid = low +f(k-1)-1
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {//关键字小于切割位置元素 继续在前部分查找
                high = mid - 1;
                /*全部元素=前部元素+后部元素
                 * f[k]=f[k-1]+f[k-2]
                 * 因为前部有f[k-1]个元素,所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
                 * 即在f[k-1]的前部继续查找 所以k--
                 * 即下次循环 mid=f[k-1-1]-1
                 * */
                k--;
            } else if (key > temp[mid]) {//关键字大于切个位置元素 则查找后半部分
                low = mid + 1;
                /*全部元素=前部元素+后部元素
                 * f[k]=f[k-1]+f[k-2]
                 * 因为后部有f[k-2]个元素,所以可以继续拆分f[k-2]=f[k-3]+f[k-4]
                 * 即在f[k-2]的前部继续查找 所以k-=2
                 * 即下次循环 mid=f[k-1-2]-1
                 * */
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}

