package com.example.springaop.controller;

import com.example.springaop.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: yzp
 * @Date: 2020-8-11 11:30
 * @description
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    public String hangdle(){
        helloService.sayHello();
        helloService.throwException();
        return "hangdle成功";
    }

}
