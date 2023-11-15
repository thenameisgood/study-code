package com.wang.spring.service;

import com.wang.spring.domain.entity.User;

import java.util.List;

public interface UserService {
    List<User> findUsers();
}
