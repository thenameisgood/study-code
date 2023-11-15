package com.wang.service;

import com.wang.entity.User;

import java.util.List;

public interface UserService {
    List<User> selectAllUser();

    void saveOneUser(User user);
}
