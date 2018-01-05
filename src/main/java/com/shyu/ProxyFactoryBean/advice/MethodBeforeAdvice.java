package com.shyu.ProxyFactoryBean.advice;

import java.lang.reflect.Method;

/**
 * Created by hangyu.shen on 2018/01/05.
 */
public class MethodBeforeAdvice implements
        org.springframework.aop.MethodBeforeAdvice {

    public void before(Method arg0, Object[] arg1, Object arg2)
            throws Throwable {
        System.out.println("==Before==");

    }

}
