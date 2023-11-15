package com.wang.controller;

import com.wang.annotation.MyLog;
import com.wang.domain.ResponseResult;
import com.wang.domain.entity.User;
import com.wang.filter.JwtAuthenticationFilter;
import com.wang.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Autowired
    private LoginService loginService;

    @MyLog(businessName = "login方法")
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        logger.info("user:{}",user);
        System.out.println(user);
        Map login = loginService.login(user);
        return ResponseResult.okResult(login);
    }
}

