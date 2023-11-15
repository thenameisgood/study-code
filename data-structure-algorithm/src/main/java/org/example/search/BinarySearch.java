package org.example.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二分查找，必须有序
 * @date: 2022/10/15 16:49
 *
 * @author: ht
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 7, 21, 34, 67, 90,90, 203, 543, 678, 2888, 86654};
        ArrayList<Integer> search = search(arr, 7, 0, arr.length -1 );
        System.out.println("搜索的下标是：");
        search.forEach(System.out::println);
    }

    public static ArrayList<Integer> search(int[] arr, int data, int low, int high) {
        System.out.println("执行了一次");
        if (low > high) {
            return new ArrayList<>();
        }
        int mid = (low + high) / 2;
        if (arr[mid] == data) {
            //假如有多个匹配的值
            ArrayList<Integer> indexList = new ArrayList<>();
            indexList.add(mid);
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != data) {
                    break;
                }
                indexList.add(temp);
                temp -= 1;
            }
            temp = mid + 1;
            while (true) {
                if (temp > arr.length -1 || arr[temp] != data) {
                    break;
                }
                indexList.add(temp);
                temp += 1;
            }
            return indexList;
        } else if (arr[mid] > data) {
            //往左
            return search(arr, data, low, mid - 1);
        } else if(arr[mid] < data) {
            //往右
            return search(arr, data, mid + 1, high);
        }

        return new ArrayList<>();
    }

}

