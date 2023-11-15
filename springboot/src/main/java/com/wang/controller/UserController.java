package com.wang.controller;

import com.wang.annotation.MyLog;
import com.wang.domain.ResponseResult;
import com.wang.domain.entity.User;
import com.wang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MyLog(businessName = "getUsers方法")
    @GetMapping("/getUsers")
    public ResponseResult getUsers() {
        List<User> allUsers = userService.getAllUsers();
        return ResponseResult.okResult(allUsers);
    }

    @PostMapping("/hi")
    public String hi(@RequestBody String hello) {
        System.out.println(hello);
        return "Hi";
    }
}
