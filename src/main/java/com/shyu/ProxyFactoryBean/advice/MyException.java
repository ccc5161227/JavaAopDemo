package com.shyu.ProxyFactoryBean.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by hangyu.shen on 2018/01/05.
 */
public class MyException implements ThrowsAdvice {
    public void afterThrowing(Exception ex){
        System.out.println("异常通知");
    }
}
