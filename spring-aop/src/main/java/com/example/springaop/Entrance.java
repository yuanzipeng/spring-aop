package com.example.springaop;

import com.example.springaop.controller.HelloController;
import com.example.springaop.controller.HiController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: yzp
 * @Date: 2020-8-11 14:46
 * @description
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class Entrance {

    public static void main(String[] args) {
        System.out.println("=========Entrance开始AOP测试==========");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Entrance.class);
        HelloController helloController = (HelloController) applicationContext.getBean("helloController");
        helloController.hangdle();
        HiController hiController = (HiController)applicationContext.getBean("hiController");
        hiController.hangdle();
    }
}
