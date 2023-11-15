package com.wang.aspect;

import com.alibaba.fastjson.JSON;
import com.wang.annotation.MyLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut(value = "@annotation(com.wang.annotation.MyLog)")
    public void pt() {
    }

    @Around("pt()")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        try {
            handlerBefore(joinPoint);
            proceed = joinPoint.proceed();
            handlerAfter(proceed);
        } finally {
            log.info("======End======" + System.lineSeparator());
        }

        return proceed;
    }

    private void handlerAfter(Object proceed) {
        log.info("Response         ：{}", JSON.toJSON(proceed));
    }

    private void handlerBefore(ProceedingJoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        MyLog annotation = methodSignature.getMethod().getAnnotation(MyLog.class);

        //打印
        log.info("======Start======");
        log.info("URL              ：{}", request.getRequestURL());
        log.info("BusinessName     ：{}", annotation.businessName());
        log.info("HTTP Method      ：{}", request.getMethod());
        log.info("Class Method     ：{}.{}", joinPoint.getSignature().getDeclaringTypeName(), ((MethodSignature) joinPoint.getSignature()).getMethod());
        log.info("IP               ：{}", request.getRemoteHost());
        log.info("Request Args     ：{}", JSON.toJSON(joinPoint.getArgs()));

    }

}

