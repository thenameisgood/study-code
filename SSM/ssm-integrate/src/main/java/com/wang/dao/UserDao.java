package com.wang.dao;

import com.wang.entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectAll();

    void saveOne(User user);
}
