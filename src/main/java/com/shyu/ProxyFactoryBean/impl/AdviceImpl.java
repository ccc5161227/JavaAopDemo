package com.shyu.ProxyFactoryBean.impl;

import com.shyu.ProxyFactoryBean.factory.Advice;

/**
 * Created by hangyu.shen on 2018/01/05.
 */
public class AdviceImpl implements Advice {

    public void fristMethod() {
        System.out.println("==fristMethod==");
    }

    public String secondMethod() {
        System.out.println("==secondMethod==");
        return "abc";
    }

}
