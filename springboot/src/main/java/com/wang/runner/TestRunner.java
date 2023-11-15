package com.wang.runner;

import com.wang.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private RedisCache redisCache;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("应用启动时需要做的功能");
    }
}

