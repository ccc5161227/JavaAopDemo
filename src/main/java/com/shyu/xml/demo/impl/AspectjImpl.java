package com.shyu.xml.demo.impl;

/**
 * Created by hangyu.shen on 2017/12/23.
 */
//实现类
public class AspectjImpl implements AspectDao {
    //添加
    public void add() {
        System.out.println("==ADD==");
    }
    //删除
    public void delete() {
        System.out.println("==DELETE==");
    }
}

