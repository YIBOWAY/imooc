package com.course.server.service;

import com.course.server.domain.Test;
import com.course.server.domain.TestExample;
import com.course.server.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestService {
    @Resource
    private TestMapper testMapper;
    public List<Test> list(){
        TestExample testExample = new TestExample();
        testExample.createCriteria().andIdEqualTo("1");//sql中的where语句
        testExample.setOrderByClause("id desc");//sql中的order by 语句
        return testMapper.selectByExample(testExample);//select语句
    }
}
