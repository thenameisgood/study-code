package com.wang.spring.service;

public class OrderServiceImpl implements OrderService{

    private UserService userService;

    private String constructArg;

    public OrderServiceImpl() {
    }

    public OrderServiceImpl(UserService userService, String constructArg) {
        this.userService = userService;
        this.constructArg = constructArg;
    }

    @Override
    public String getOrderByUserId(Integer userId) {
        return "888888888";
    }
}

