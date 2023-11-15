package com.wang.springMybatis.dao;

import com.wang.springMybatis.entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectAll();

    void saveOne(User user);
}
