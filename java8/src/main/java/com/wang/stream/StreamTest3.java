package com.wang.stream;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest3 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        // Stream<String> stream = list.stream();
        
        Stream<String> stream = Stream.of("a", "b", "c");
        // String[] strings = stream.toArray(value -> new String[value]);
        String[] strings = stream.toArray(String[]::new);
        Arrays.asList(strings).forEach(System.out::println);

        Stream<String> stream1 = Stream.of("a", "b", "c");
        List<String> strings1 = stream1.collect(Collectors.toList());
        strings1.forEach(System.out::println);

        System.out.println("=============");

        Stream<String> stringStream = Stream.of("a", "b", "c");
        ArrayList<String> arrayList = stringStream.collect(Collectors.toCollection(ArrayList::new));
        arrayList.forEach(System.out::println);
    }
}
