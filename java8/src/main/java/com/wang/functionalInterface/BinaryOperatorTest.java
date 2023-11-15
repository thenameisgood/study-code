package com.wang.functionalInterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperatorTest binaryOperatorTest = new BinaryOperatorTest();
        int result = binaryOperatorTest.compute(1, 2, (integer, integer2) -> integer + integer2);
        int result2 = binaryOperatorTest.compute(1, 2, (integer, integer2) -> integer * integer2);
        System.out.println(result);
        System.out.println(result2);
    }

    public int compute(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }
}
