package com.wang.service.impl;

import com.wang.dao.UserDao;
import com.wang.domain.ResponseResult;
import com.wang.domain.entity.User;
import com.wang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {
        return userDao.selectUserById(id);
    }

    @Override
    public User getUserByUsername(String name) {
        return userDao.selectUserByName(name);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }
}

