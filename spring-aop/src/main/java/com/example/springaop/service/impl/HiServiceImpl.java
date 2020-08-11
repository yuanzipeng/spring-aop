package com.example.springaop.service.impl;


import com.example.springaop.service.HiService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yzp
 * @Date: 2020-8-11 11:09
 * @description
 */
@Service
public class HiServiceImpl implements HiService {
    @Override
    public void sayHi() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hi,你好");
    }

    @Override
    public String throwException() {
        throw new RuntimeException("Hi,Exception");
    }
}
