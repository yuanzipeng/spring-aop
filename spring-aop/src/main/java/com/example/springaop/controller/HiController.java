package com.example.springaop.controller;

import com.example.springaop.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author: yzp
 * @Date: 2020-8-11 11:30
 * @description
 */
@Controller
public class HiController {

    @Autowired
    private HiService hiService;

    public void hangdle(){
        hiService.sayHi();
        hiService.throwException();
    }

}
