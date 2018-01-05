package com.shyu.annotation.demo.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by hangyu.shen on 2017/12/23.
 */

@org.aspectj.lang.annotation.Aspect
public class Aspect {
    //前置增强
    @Before(value="execution(public * *(..))")
    public void asBefore(){
        System.out.println("这是前置增强");
    }
    //后置增强
    @AfterReturning(value="execution(public * *(..))")
    public void asAfterReturning(){
        System.out.println("这是后置增强");
    }
    //环绕增强
    @Around(value="execution(public * *(..))")
    public void asAround(ProceedingJoinPoint pj){
        System.out.println("这是环绕前置增强");
        try {
            pj.proceed();
        } catch (Throwable e) {
            //抓捕异常
            e.printStackTrace();
        }
        System.out.println("这是环绕后置增强");
    }
    //异常增强
    @AfterThrowing(value="execution(public * *(..))")
    public void asThorws(){
        System.out.println("这是异常增强");
    }
    //最终增强
    @After(value="execution(public * *(..))")
    public void asAfter(){
        System.out.println("这是最终增强");
    }
}
