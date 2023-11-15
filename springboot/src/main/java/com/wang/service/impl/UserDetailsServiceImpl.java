package com.wang.service.impl;

import com.wang.dao.UserDao;
import com.wang.domain.vo.SecurityLoginUser;
import com.wang.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * @Description:
 * @Author: ht
 * @Date: 2022/9/5 17:24
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("UserDetailsServiceImpl的loadUserByUsername方法");
        //这里的user不能直接返回，因为不是UserDetails类型的，所以要定义一个类，这个类要实现UserDetails接口；当然也可以把User类直接实现UserDetails接口
        User user = userDao.selectUserByName(s);

        if (Objects.isNull(user)) {
            System.out.println("用户名不存在，抛出错误，而后进入AuthenticationEntryPointImpl。来自UserDetailsServiceImpl的loadUserByUsername方法");
            throw new RuntimeException("用户名不存在");
        }
        System.out.println("loadUserByUsername成功，说明有该用户（有的话，继续往下走，返回SecurityLoginUser对象，里面包含了从数据库查询出来的user和权限信息），但此时还没有进行密码校验，");
        //返回用户信息
        //查询权限信息封装
        //如果是后台用户 才需要查询权限
//        if (user.getType().equals(SystemConstants.ADMIN)) {
//            List<String> permissionList = menuMapper.selectPermissionsByUserId(user.getId());
//            return new LoginUser(user, permissionList);
//        }
        List<String> permissions = null;
        return new SecurityLoginUser(user, permissions);
    }
}

