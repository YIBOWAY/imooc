package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.mapper.ChapterMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterService {
    @Resource
    private ChapterMapper chapterMapper;
    public List<Chapter> list(){
        ChapterExample chapterExample = new ChapterExample();
        chapterExample.createCriteria().andIdEqualTo("1");//sql中的where语句
        chapterExample.setOrderByClause("id desc");//sql中的order by 语句
        return chapterMapper.selectByExample(chapterExample);//select语句
    }
}
