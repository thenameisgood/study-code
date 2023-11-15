package com.wang.service;

import com.wang.domain.ResponseResult;
import com.wang.domain.entity.User;

import java.util.Map;

public interface LoginService {
    Map login(User user);

}
