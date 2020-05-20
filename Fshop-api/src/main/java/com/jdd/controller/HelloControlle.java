package com.jdd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloControlle {


    @GetMapping("/hello")
    public Object hello(){
        return "hello world";
    }


}
