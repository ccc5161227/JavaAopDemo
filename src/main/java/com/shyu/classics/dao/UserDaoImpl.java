package com.shyu.classics.dao;

/**
 * Created by hangyu.shen on 2017/12/23.
 */
//实现类

import com.shyu.classics.entity.User;

public class UserDaoImpl implements UDao {

    public void save(User user) {
        System.out.println("保存成功");
    }
}
