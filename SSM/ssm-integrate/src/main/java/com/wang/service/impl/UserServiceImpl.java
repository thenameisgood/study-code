package com.wang.service.impl;

import com.wang.dao.UserDao;
import com.wang.entity.User;
import com.wang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAll();
    }

    @Override
    public void saveOneUser(User user) {
        userDao.saveOne(user);
    }
}

