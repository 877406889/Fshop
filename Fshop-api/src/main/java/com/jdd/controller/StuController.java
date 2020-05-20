package com.jdd.controller;

import com.jdd.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuController {
    @Autowired
    private StuService stuService;

    @GetMapping("/getStu")
    public Object getStu(Integer id){
        return stuService.getStuInfo(id);
    }

    @PostMapping("/save")
    public Object saveStu (){
        stuService.saveStu();
        return "OK";
    }

    @PostMapping("/updateStu")
    public Object updateStu (Integer id){
        stuService.updateStu(id);
        return "OK";
    }

    @PostMapping("/deleteStu")
    public Object deleteStu (Integer id){
        stuService.deleteStu(id);
        return "OK";
    }

}
