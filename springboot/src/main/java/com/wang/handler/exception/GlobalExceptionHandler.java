package com.wang.handler.exception;

import com.wang.domain.ResponseResult;
import com.wang.enums.HttpCodeEnum;
import com.wang.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MyException.class)
    public ResponseResult myExceptionHandler(MyException e){
        //打印异常信息
        System.out.println("-------------------------");
        log.error("出现了异常！ {}，GlobalExceptionHandler#myExceptionHandler",e.getMessage());
        //从异常对象中获取提示信息封装返回
        return ResponseResult.errorResult(e.getCode(),e.getMsg()+"GlobalExceptionHandler#systemExceptionHandler()");
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e){
        //HttpRequestMethodNotSupportedException 请求方法不匹配
        //打印异常信息
        System.out.println("=========================");
        log.error("出现了异常！！ {}，GlobalExceptionHandler#exceptionHandler",e.getMessage());
        //从异常对象中获取提示信息封装返回  用户名不存在/密码错误
        return ResponseResult.errorResult(HttpCodeEnum.SYSTEM_ERROR.getCode(),HttpCodeEnum.SYSTEM_ERROR.getMsg()+"GlobalExceptionHandler#exceptionHandler()");
    }
}

