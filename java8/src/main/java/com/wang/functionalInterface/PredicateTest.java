package com.wang.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        conditionFilter(list, integer -> integer % 2 == 0);
    }

    /**
     * 函数式编程提供了更高层次的抽象化
     */
    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
    }
}
