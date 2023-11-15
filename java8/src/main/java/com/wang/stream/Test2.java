package com.wang.stream;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[] arrayA = new int[]{1, 2, 3};
        int[] arrayB = new int[]{4, 5, 6};
        System.out.println("交换前：" + Arrays.toString(arrayA) + " " + Arrays.toString(arrayB));
        swapArray(arrayA, arrayB);
        System.out.println("交换后：" + Arrays.toString(arrayA) + " " + Arrays.toString(arrayB));

        System.out.println("-------------");

        int[] array = new int[]{1, 2, 3};
        System.out.println("array前 " + array[0]);
        change(array);
        System.out.println("array后 " + array[0]);
    }

    /**
     * 对于对象 传递的仅仅是引用的地址
     * */
    public static  void swapArray(int[] a, int[] b) {
        int[] c = a;
        a = b;
        b = c;
        // a[0] = 666;
        // b[0] = 666;
        System.out.println("交换方法：" + Arrays.toString(a) + " " + Arrays.toString(b));
    }

    public static void change(int[] intArray) {
        System.out.println("change前 " + intArray[0]);
        intArray[0] = 100;
        System.out.println("change后 " + intArray[0]);
    }
}
