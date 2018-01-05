package com.shyu.ProxyFactoryBean;

import com.shyu.ProxyFactoryBean.factory.Advice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 参考链接：http://blog.csdn.net/u010889616/article/details/52433595
 * Created by hangyu.shen on 2018/01/05.
 */
public class Test2 {
    /**
     * appContextProxyFactory2.xml的配置简洁易懂
     *
     * 获得目标类：对应方法没有执行，仅增强通知执行了
     * 获得代理类：方法和增强通知均有执行
     */
    public static void main(String[] args) {
        //解析配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContextProxyFactory2.xml");

        // 获得目标类
        Advice advice = (Advice) ctx.getBean("adviceimpl");
        advice.fristMethod();
        advice.secondMethod();

        System.out.println("===================================");

        // 获得代理类
        Advice advice2 = (Advice) ctx.getBean("personServiceProxyId");
        advice2.fristMethod();
        advice2.secondMethod();
    }
}
