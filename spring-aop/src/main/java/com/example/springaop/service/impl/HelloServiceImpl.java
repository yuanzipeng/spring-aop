package com.example.springaop.service.impl;


import com.example.springaop.service.HelloService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yzp
 * @Date: 2020-8-11 11:09
 * @description
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello,你好");
    }

    @Override
    public void throwException() {
        throw new RuntimeException("Hello,Exception");

    }
}
