package com.wang.job;

import com.wang.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/6 21:06
 */
@Component
public class MyJob {

//    @Autowired
//    private RedisCache redisCache;

    @Scheduled(cron = "0/10 * * * * ? ")
    public void job() {
        System.out.println("定时执行任务");
    }
}



