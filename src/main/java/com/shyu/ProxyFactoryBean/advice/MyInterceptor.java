package com.shyu.ProxyFactoryBean.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by hangyu.shen on 2018/01/05.
 */
public class MyInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("==before==");
        String result= (String)invocation.proceed();
        System.out.println("==after==");
        return result;
    }
}
