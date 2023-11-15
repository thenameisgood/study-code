package com.wang.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(4, 5, 1, 7, 8, 0, 9);
        intStream.forEach(System.out::println);

        System.out.println("------------");
        IntStream.range(3, 10).forEach(System.out::println);

        System.out.println("------------");
        List<Integer> list = Arrays.asList(4, 1, 6, 7, 8, 2, 9);
        System.out.println(list.stream().map(i -> 2 * i).reduce(0, Integer::sum));
    }
}
