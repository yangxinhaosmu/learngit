package com.atguigu.spring.test;

import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnno {


    @Test
    public void test(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc-anno.xml");
        UserController usercontroller = ioc.getBean("userController",UserController.class);
//        System.out.println(usercontroller);
//        UserService userService = ioc.getBean(UserService.class);
//        System.out.println(userService);
//        UserDao userDao = ioc.getBean(UserDao.class);
//        System.out.println(userDao);
        usercontroller.saveUser();
    }
}
