package com.course.system.service;

import com.course.system.mapper.TestMapper;
import org.springframework.stereotype.Service;
import com.course.system.domain.mybatis_study;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {
    @Resource
    private TestMapper testMapper;
    public List<mybatis_study> list(){
        return testMapper.list();
    }
}
