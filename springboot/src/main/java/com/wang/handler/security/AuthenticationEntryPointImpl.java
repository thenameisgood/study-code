package com.wang.handler.security;

import com.alibaba.fastjson.JSON;
import com.wang.domain.ResponseResult;
import com.wang.enums.HttpCodeEnum;
import com.wang.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败
 * 用户名不存在：InternalAuthenticationServiceException
 * 密码错误：BadCredentialsException
 * 没有携带token也会由该类进行处理(因为过滤器JwtAuthenticationFilter设置的如果没有token就放行) InsufficientAuthenticationException
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authException) throws IOException, ServletException {
        System.out.println("进入AuthenticationEntryPointImpl的commence方法");
        //打印错误
        authException.printStackTrace();

        //InsufficientAuthenticationException
        //BadCredentialsException
        ResponseResult result = null;
        if (authException instanceof BadCredentialsException) {
            System.out.println("密码错误");
//            result = ResponseResult.errorResult(HttpCodeEnum.LOGIN_ERROR.getCode(), authException.getMessage() + "AuthenticationEntryPointImpl#commence()" + "==BadCredentialsException");
        } else if (authException instanceof InsufficientAuthenticationException) {
            System.out.println("没有携带token");
//            result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN.getCode(), authException.getMessage() + "AuthenticationEntryPointImpl#commence()" + "==InsufficientAuthenticationException");
        }
        result = ResponseResult.errorResult(HttpCodeEnum.SYSTEM_ERROR.getCode(), HttpCodeEnum.SYSTEM_ERROR.getMsg() + "AuthenticationEntryPointImpl#commence()");
        System.out.println("返回数据，AuthenticationEntryPointImpl的commence方法");
        //响应给前端
        WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
    }
}

