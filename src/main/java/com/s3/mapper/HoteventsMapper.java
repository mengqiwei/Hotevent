package com.s3.mapper;

import com.s3.pojo.Hotevents;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HoteventsMapper {
    //分页
    public List<Hotevents> getPage(
            @Param("keyWord")String keyWord,
            @Param("form")Integer form,
            @Param("pageSize")Integer pageSize
    );

    public int getCount(
            @Param("keyWord")String keyWord
    );

    //根据id查询信息
    public Hotevents getById(@Param("id")Integer id);
    //浏览量+1
    public int add1(@Param("id")Integer id);
}
