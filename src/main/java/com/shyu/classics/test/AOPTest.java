package com.shyu.classics.test;

import com.shyu.classics.biz.UBiz;
import com.shyu.classics.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hangyu.shen on 2017/12/23.
 */
public class AOPTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextClassics.xml");
        UBiz ubiz = (UBiz) context.getBean("biz");
        User user = new User();
        ubiz.save2(user);
        System.out.println("save~ok");
    }
}
