package com.atguigu.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class DataSourceTest {

    @Test
    public void testDS() throws SQLException {
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource ds = ioc.getBean(DruidDataSource.class);
        System.out.println(ds.getConnection());
    }
}
