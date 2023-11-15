package com.wang.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);

        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        // optional.ifPresent(System.out::println);

        System.out.println(optional.orElse("word"));

        System.out.println(optional.orElseGet(() -> "nihao"));

    }
}
