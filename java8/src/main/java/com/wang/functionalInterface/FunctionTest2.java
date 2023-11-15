package com.wang.functionalInterface;

import java.util.function.Function;

public class FunctionTest2 {
    public static void main(String[] args) {
        FunctionTest2 functionTest2 = new FunctionTest2();

        int result1 = functionTest2.compute1(2, integer -> integer * 3, integer -> integer * integer);
        int result2 = functionTest2.compute2(2, integer -> integer * 3, integer -> integer * integer);

        System.out.println(result1);
        System.out.println(result2);
    }

    public int compute1(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }
}
