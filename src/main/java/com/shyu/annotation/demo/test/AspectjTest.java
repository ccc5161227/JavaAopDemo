package com.shyu.annotation.demo.test;

import com.shyu.annotation.demo.impl.AspectDao;
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
                "applicationContextAnnotation.xml");
        AspectDao aspect = (AspectDao) ctx.getBean("aspectimpl");
        aspect.add();
        aspect.delete();
    }
}
