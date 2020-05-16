package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.dto.ChapterDto;
import com.course.server.mapper.ChapterMapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterService {
    @Resource
    private ChapterMapper chapterMapper;
    public List<ChapterDto> list(){
        ChapterExample chapterExample = new ChapterExample();
//        chapterExample.createCriteria().andIdEqualTo("1");//sql中的where语句
//        chapterExample.setOrderByClause("id desc");//sql中的order by 语句
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);//select语句
        List<ChapterDto> chapterDtoList = new ArrayList<ChapterDto>();
        for (int i = 0, l = chapterList.size();i<l; i++) {
            Chapter chapter = chapterList.get(i);
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter,chapterDto);//拷贝，把chapter中的值拷贝到数据传输层
            chapterDtoList.add(chapterDto);
        }
        return chapterDtoList;
    }
}