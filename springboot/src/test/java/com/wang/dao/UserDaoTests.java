package com.wang.dao;

import com.wang.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDaoTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void selectUserByName(){
        User user = userDao.selectUserByName("小老虎");
        System.out.println(user);
    }

    @Test
    public void selectUserById(){
        User user = userDao.selectUserById(3L);
        System.out.println(user);
    }
}

