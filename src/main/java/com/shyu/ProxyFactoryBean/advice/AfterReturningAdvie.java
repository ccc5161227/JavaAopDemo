package com.shyu.ProxyFactoryBean.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by hangyu.shen on 2018/01/05.
 */
public class AfterReturningAdvie implements AfterReturningAdvice {

    public void afterReturning(Object arg0, Method arg1, Object[] arg2,
                               Object arg3) throws Throwable {
        System.out.println("==After==");

    }

}
