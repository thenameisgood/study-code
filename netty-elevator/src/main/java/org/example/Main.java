package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.netty.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Main implements CommandLineRunner {

    @Autowired
    private RedisTemplate redisTemplate;
 
    @Autowired
    private NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动netty了");
        nettyServer.run();

        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPush("key","");
        listOperations.leftPushAll("key", new ArrayList());
        List list = listOperations.rightPop("key", 10);
    }
}