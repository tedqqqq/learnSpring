package com.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.pojo.Person;



public class TestMain {
    public static void main(String[] args) {
//    	/learnSpring/src/main/resources/bean.xml
//    	/learnSpring/src/main/java/bean.xml
        // 创建 Spring 的 IOC 容器
   //     ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ctx=new FileSystemXmlApplicationContext("E:/learngit/learnSpring/learnSpring/src/main/java/bean.xml");
        // 使用 getBean() 方法, 通过传入刚才的 id 名,来获取 bean, 但是这里返回的是一个 Object 对象, 所以要转型
        Person person = (Person) ctx.getBean("person");
        // 打印 person
        System.out.println(person.info());
    }
}

