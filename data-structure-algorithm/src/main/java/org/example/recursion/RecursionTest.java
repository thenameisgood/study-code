package org.example.recursion;

/**
 * @Description: 递归
 * @Author: ht
 * @Date: 2022/10/14 13:48
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(5);
    }

    public static void test(int n) {
        if (n > 3) {
            test(n - 1);
        }
        System.out.println("n=" + n);
    }

    //阶乘
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}

