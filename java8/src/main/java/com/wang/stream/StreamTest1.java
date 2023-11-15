package com.wang.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        Stream<Object> of = Stream.of("hello", "word", "hw");

        String[] stringArray = new String[]{"hello", "word", "hw"};
        Stream<String> stringStream = Stream.of(stringArray);
        Stream<String> stream = Arrays.stream(stringArray);

        List<String> list = Arrays.asList(stringArray);
        Stream<String> stream1 = list.stream();
        
        
    }
    
}
