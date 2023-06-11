package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.pojo.Student;
import com.atguigu.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {

    @Test
    public void testScope(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-scope.xml");
        Student student1 = ioc.getBean(Student.class);
        Student student2 = ioc.getBean(Student.class);
        System.out.println(student1.equals(student2));
    }

    @Test
    public void testLife(){
        ConfigurableApplicationContext ioc=new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();//ioc容器关闭时销毁
    }

    @Test
    public void testFactory(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }

    @Test
    public void testAutoW(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
