package com.zhibin.realworld.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {
    // 定义切点方法 Controller 包下、子孙包下所有类的所有方法
    @Pointcut("execution(* com.zhibin.realworld.controller..*.*(..))")
    public void  pointcut(){}
    // 前置通知
    @Before("pointcut()")
    public void doBefore() {}

    // 环绕通知
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object obj = null;
        System.out.println("Around 方法开始执行");
        try {
            //invoke 要调用的真实方法
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("Around 方法结束执行");
        return obj;
    }
}
