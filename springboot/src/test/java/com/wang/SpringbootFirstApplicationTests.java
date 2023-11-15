package com.wang;

import com.wang.dao.UserDao;
import com.wang.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringbootFirstApplicationTests {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Test
    void contextLoads() {
    }

    @Test
    public void BCryptPasswordEncoder() {
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }

}
