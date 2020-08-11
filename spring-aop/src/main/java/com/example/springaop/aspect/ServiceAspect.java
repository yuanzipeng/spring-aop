package com.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: yzp
 * @Date: 2020-8-11 11:36
 * @description
 */
@Aspect
@Component
public class ServiceAspect {

    /**
     * 第一个*表示任何返回值的方法都会被触发
     * 第一个..表示package及子package下的
     * 第二个*表示所有类
     * .*表示类里所有方法
     * (..)表示不管方法需要传入多少个参数或者没有参数
     */
    @Pointcut("execution(* com.example.springaop.service..*.*(..))")
    public void embed() {
    }

    @Before("embed()")
    public void before(JoinPoint joinPoint){
        System.out.println("before开始调用joinPoint："+joinPoint);
    }

    @After("embed()")
    public void after(JoinPoint joinPoint){
        System.out.println("after开始调用joinPoint："+joinPoint);
    }

    @Around("embed()")
    public Object around(JoinPoint joinPoint) {
        Object returnValue = null;
        try {
            long startTime = System.currentTimeMillis();
            returnValue = ((ProceedingJoinPoint)joinPoint).proceed();
            long endTime = System.currentTimeMillis();
            System.out.println("around总耗时："+(endTime-startTime)+"ms,调用失败："+joinPoint);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("around调用失败："+ joinPoint+",异常："+throwable);
        }
        return returnValue;
    }

    @AfterReturning(pointcut = "embed()",returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint,Object returnValue){
        System.out.println("afterReturning调用："+joinPoint+"返回值："+returnValue);
    }

    @AfterThrowing(pointcut = "embed()",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint,Exception exception){
        System.out.println("afterThrowing调用抛出异常："+joinPoint+"返回异常："+exception);
    }

}
