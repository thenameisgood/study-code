package com.wang.service;

import com.wang.domain.ResponseResult;
import com.wang.domain.entity.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);
    User getUserByUsername(String name);

    List<User> getAllUsers();

}
