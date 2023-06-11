package com.atguigu.spring.test;

import com.atguigu.spring.pojo.Student;
import com.atguigu.spring.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {

    @Test
    public void testIOC(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
        //Student studentOne = (Student) ioc.getBean("studentOne");
        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }

    @Test
    public void testDI(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ioc.getBean("studentTwo", Student.class);
        System.out.println(student);

    }

}
