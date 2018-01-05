package com.shyu.classics.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by hangyu.shen on 2017/12/23.
 */
//后置内容

public class LoggerAfter implements AfterReturningAdvice {

    public void afterReturning(Object arg0, Method arg1, Object[] arg2,
                               Object arg3) throws Throwable {
        System.out.println("save后置内容");
    }
}

