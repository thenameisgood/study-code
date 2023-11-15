package com.wang.dao;

import com.wang.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    User selectUserById(@Param("id") Long id);

    User selectUserByName(@Param("name") String name);

    List<User> selectAllUsers();
}
