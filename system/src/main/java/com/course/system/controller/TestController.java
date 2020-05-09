package com.course.system.controller;


import com.course.system.service.TestService;
import com.course.system.domain.mybatis_study;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private TestService testService;
    @RequestMapping("/test")
    public List<mybatis_study> test(){
        return testService.list();
    }
}