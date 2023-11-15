package com.wang.functionalInterface;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        // 函数式接口：Function
        FunctionTest functionTest = new FunctionTest();
        String compute = functionTest.compute(1, new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(100 * integer + "%");
            }
        });

        String compute2 = functionTest.compute(1, integer -> String.valueOf(1000 * integer + "$"));

        System.out.println(compute);
        System.out.println(compute2);
    }

    public String compute(int a, Function<Integer, String> function) {
        String result = function.apply(a);
        return result;
    }
}
