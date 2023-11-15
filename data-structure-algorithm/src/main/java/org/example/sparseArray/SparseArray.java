package org.example.sparseArray;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/10/13 12:16
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][4] = 2;

        System.out.println("原始的二维数组:");
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val);
            }
            System.out.println();
        }

//        遍历原始二维数组
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("不为0的个数" + sum);

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0] = new int[]{arr.length, arr[0].length, sum};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[sum] = new int[]{i, j, arr[i][j]};
                    sum--;
                }
            }
        }

        System.out.println("稀疏数组：");
        for (int[] row : sparseArr) {
            for (int val : row) {
                System.out.print(val);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("恢复的数组：");
        int[][] restoreArr = new int[sparseArr[0][0]][sparseArr[0][1]];
//        for (int i = 1; i <= sparseArr[0][2]; i++) {
//            restoreArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
//        }
        for (int i = 1; i < sparseArr.length; i++) {
            restoreArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int[] row : restoreArr) {
            for (int val : row) {
                System.out.print(val);
                System.out.print(" ");
            }
            System.out.println();
        }


    }
}

