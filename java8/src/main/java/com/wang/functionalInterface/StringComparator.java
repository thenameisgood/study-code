package com.wang.functionalInterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringComparator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("zhangsan", "lisi", "wangwu");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        list.sort((o1, o2) -> o2.compareTo(o1));
        list.sort(Comparator.reverseOrder());
        

        System.out.println(list);
    }
}
