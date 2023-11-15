package com.wang.filter;

import com.alibaba.fastjson.JSON;
import com.wang.domain.ResponseResult;
import com.wang.domain.vo.SecurityLoginUser;
import com.wang.enums.HttpCodeEnum;
import com.wang.utils.JwtUtils;
import com.wang.utils.RedisCache;
import com.wang.utils.WebUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("进入自定义的JwtAuthenticationFilter过滤器的doFilterInternal方法，下面获取请求头中的token");

        //获取请求头中的token
        String token = request.getHeader("token");
        if(!StringUtils.hasText(token)){
            System.out.println("进入了if(!StringUtils.hasText(token))判断，说明没有携带token，没有携带token说明接口不需要登录，可直接放行");
            //说明该接口不需要登录  直接放行
            filterChain.doFilter(request, response);
            return;
        }

        System.out.println("走到这里，说明有token，接下来进行token验证");
        //解析获取userid
        Claims claims = null;
        try {
            claims = JwtUtils.parseJWT(token);
        } catch (Exception e) {
            System.out.println("捕获到异常，说明token解析失败，token超时或违法，接下来返回数据，告诉前端需要登录");
            e.printStackTrace();
            //token超时或非法
            //响应告诉前端需要重新登录
            ResponseResult result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(result));
            return;
        }
        System.out.println("走到这里，说明token没问题，可以放行，接下来就可以根据解析token得到的id进行缓存获取，存入SecurityContextHolder");
        String userId = claims.getSubject();

        //从redis中获取用户信息
        SecurityLoginUser securityLoginUser = redisCache.getCacheObject("loginId:" + userId);

        //如果获取不到
        if(Objects.isNull(securityLoginUser)){
            System.out.println("进入到if(Objects.isNull(securityLoginUser))，说明redis中没有查询到相关信息，则返回数据，告诉前端需要登陆");
            //说明登录过期  提示重新登录
            ResponseResult result = ResponseResult.errorResult(HttpCodeEnum.NEED_LOGIN);
            WebUtils.renderString(response, JSON.toJSONString(result));
            return;
        }

        System.out.println("走到这里，说明token没问题，且redis中有信息，可以放行，放行之前，把数据存入到SecurityContextHolder");
        //存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(securityLoginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);
    }
}

