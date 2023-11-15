package com.wang.config;

import com.wang.filter.JwtAuthenticationFilter;
import com.wang.handler.security.AccessDeniedHandlerImpl;
import com.wang.handler.security.AuthenticationEntryPointImpl;
import com.wang.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)//表示：使用注解 指定访问对应的资源所需的权限
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationTokenFilter;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint;

    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;

//    @Autowired
//    private LoginSuccessAuthenticationSuccessHandlerImpl authenticationSuccessHandler;
//
//    @Autowired
//    private LoginFailAuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

    // 白名单
//    private static final String[] URL_WHITELIST = {
//            "/blog/login",
////            "/blog/logout",
//            "/captcha",
//            "/favicon.ico",
//            "/swagger-ui.html",
//            "/webjars/**",
//            "/swagger-resources/**",
//            "/v2/api-docs/**",
//            "/excel/importExcel",
//            "/excel/exportExcel",
//            "/captcha",
//    };

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 暴露authenticationManagerBean AuthenticationManager#authenticate()进行用户认证
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(URL_WHITELIST);
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 添加过滤器
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)

                //关闭csrf
                .csrf().disable()

                //允许跨域
                .cors()
                .and()

//                 认证成功处理器  不管用
//                .formLogin()
//                .loginProcessingUrl("/blog/login")
//                .successHandler(authenticationSuccessHandler) //.配置认证失败处理器
//                .failureHandler(authenticationFailureHandlerImpl)

//                .and()
                //不通过Session获取SecurityContext
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                // 对于登录接口 允许匿名访问
                .antMatchers("/login").anonymous()
//                .antMatchers(URL_WHITELIST).permitAll()
                //除了注解配置权限， 基于配置也可以实现
//                .antMatchers("/user/hello").hasAuthority("/home")
                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated()

                .and()
                //配置异常处理器  让异常可以发送给前端
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
        //关闭默认的注销功能
        http.logout().disable();
    }
}
