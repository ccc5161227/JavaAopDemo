package com.shyu.ProxyFactoryBean;

import com.shyu.ProxyFactoryBean.factory.Advice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 参考链接：https://www.cnblogs.com/bdpsc/p/5955494.html
 * Created by hangyu.shen on 2018/01/05.
 */
public class Test {
    /**
     * 与Test2的获取目标类方式一样，但是appContextProxyFactory.xml配置不一样
     *
     * 相同点：Test和Test2都有用“获得目标类”方式来获取bean
     * 不同点：Test中既执行方法，也执行了增强通知（应该是配置中实现了自动代理）；而Test2中没有执行方法，担有通知
     */
    public static void main(String[] args) {
        //解析配置文件
        ApplicationContext ctx=new ClassPathXmlApplicationContext("appContextProxyFactory.xml");
        // 获得目标类
        Advice advice= (Advice)ctx.getBean("adviceimpl"); //自动代理beanname的方式
        advice.fristMethod();
        advice.secondMethod();
    }
}
