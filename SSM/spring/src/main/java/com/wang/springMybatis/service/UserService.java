package com.wang.springMybatis.service;

import com.wang.springMybatis.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUser();

    void saveOneUser(User user);
}
