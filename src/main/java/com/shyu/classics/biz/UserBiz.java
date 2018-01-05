package com.shyu.classics.biz;

import com.shyu.classics.dao.UDao;
import com.shyu.classics.entity.User;

/**
 * Created by hangyu.shen on 2017/12/23.
 */
//业务实现类

public class UserBiz implements UBiz{

    //dao的对象
    private UDao udao;
    public void save2(User user) {
        udao.save(user);

    }
    public UDao getUdao() {
        return udao;
    }
    public void setUdao(UDao udao) {
        this.udao = udao;
    }

}

