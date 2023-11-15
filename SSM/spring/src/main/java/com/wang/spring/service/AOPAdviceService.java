package com.wang.spring.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class AOPAdviceService implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("MethodBeforeAdvice#before执行了");
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("AfterReturningAdvice#afterReturning执行了");
    }

    //参数: invocation 获取当前执行方法 获取当前执行方法参数 获取目标对象
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("==========进入环绕通知===========");
        System.out.println("当前执行方法:" +methodInvocation.getMethod().getName());
        System.out.println("方法的参数: "+methodInvocation.getArguments());
        System.out.println("获取当前的目标对象: "+methodInvocation.getThis());
        try{
            //放行目标方法
            Object proceed = methodInvocation.proceed();//继续处理
            return proceed;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("出现异常时业务处理");
        }
        return null;
    }

    //出现异常时执行通知处理
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("===========进入异常通知============");
        System.out.println("异常信息: "+ex.getMessage());
    }



}

