package com.wang.service.impl;

import com.wang.domain.vo.SecurityLoginUser;
import com.wang.domain.entity.User;
import com.wang.domain.vo.UserInfoVo;
import com.wang.service.LoginService;
import com.wang.service.UserService;
import com.wang.utils.BeanCopyUtils;
import com.wang.utils.JwtUtils;
import com.wang.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisCache redisCache;

    @Override
    public Map login(User user) {
        System.out.println("进入LoginServiceImpl的login方法，开始认证：");
        //UsernamePasswordAuthenticationToken实现了Authentication接口
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword());
        System.out.println("usernamePasswordAuthenticationToken创建完成，进入UserDetailsServiceImpl的loadUserByUsername方法，如果load成功则返回此处(继续往下进行authenticate验证密码)，如果不成功，在load中发生错误，抛出用户不存在异常，异常由AuthenticationEntryPointImpl的commence方法处理");

        //authenticate会调用userDetailService去认证，默认从内存中获取，所以要重写userDetailService从数据库中获取
        //下面这一行，验证了用户是否存在以及密码是否正确
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        System.out.println("authenticationManager的authenticate方法认证成功啦！！走到这里，说明密码没有错误，接下来生成token");

        //获取userId，生成token
        SecurityLoginUser securityLoginUser = (SecurityLoginUser) authenticate.getPrincipal();
        String id = securityLoginUser.getUser().getId().toString();
        String jwt = JwtUtils.createJWT(id);
        //把用户信息存入redis
        redisCache.setCacheObject("loginId:" + id, securityLoginUser);
        System.out.println("存入redis成功，接下来封装返回数据");
        //把token和userInfo封装返回
        //可以用map
        HashMap<Object, Object> map = new HashMap<>();
        map.put("token", jwt);
        map.put("userInfo", BeanCopyUtils.copyBean(securityLoginUser.getUser(), UserInfoVo.class));
        System.out.println("LoginServiceImpl的login方法执行完成，准备返回数据了");
        return map;
    }
}

