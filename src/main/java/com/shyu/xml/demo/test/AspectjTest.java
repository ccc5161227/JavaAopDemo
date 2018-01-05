package com.shyu.xml.demo.test;

import com.shyu.xml.demo.impl.AspectDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hangyu.shen on 2017/12/23.
 */
public class AspectjTest {
    /**
     * 注解测试 */
    public static void main(String[] args) {
        // 解析配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContextXml.xml");
        AspectDao aspect = (AspectDao) ctx.getBean("aspectimpl");
//        AspectDao aspect = new AspectjImpl();
        aspect.add();
        aspect.delete();
    }
}
