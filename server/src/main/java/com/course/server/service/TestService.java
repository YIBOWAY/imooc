package com.course.server.service;

import com.course.server.domain.mybatis_study;
import com.course.server.mapper.TestMapper;
import org.springframework.stereotype.Service;

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
