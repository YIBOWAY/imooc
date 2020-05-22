package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.ChapterMapper;
import com.course.server.util.UuidUtil;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterService {
    @Resource
    private ChapterMapper chapterMapper;
    public void list(PageDto pageDto){
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());//执行的第一个select语句会进行分页
        ChapterExample chapterExample = new ChapterExample();
//        chapterExample.createCriteria().andIdEqualTo("1");//sql中的where语句
        chapterExample.setOrderByClause("id desc");//sql中的order by 语句
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);//select语句
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        pageDto.setTotal(pageInfo.getTotal());//得到总行数
        List<ChapterDto> chapterDtoList = new ArrayList<ChapterDto>();
        for (int i = 0, l = chapterList.size();i<l; i++) {
            Chapter chapter = chapterList.get(i);
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter,chapterDto);//拷贝，把chapter中的值拷贝到数据传输层
            chapterDtoList.add(chapterDto);
        }
        pageDto.setList(chapterDtoList);//传给前端的都是DTO层
        //分页参数：page：分的页数；list：每页的条数
    }

    public void save(ChapterDto chapterDto){
        chapterDto.setId(UuidUtil.getShortUuid());//生成UID
        Chapter chapter = new Chapter();
        BeanUtils.copyProperties(chapterDto,chapter);
        chapterMapper.insert(chapter);

    }
}
