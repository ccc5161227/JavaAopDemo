package com.shyu.classics.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by hangyu.shen on 2017/12/23.
 */

//前置内容
public class LoggerBefore implements MethodBeforeAdvice {

    public void before(Method arg0, Object[] arg1, Object arg2)
            throws Throwable {
        System.out.println("save前置内容");
    }
}


