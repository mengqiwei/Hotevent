package com.s3.service;

import com.s3.pojo.Hotevents;
import com.s3.util.PageUtil;


public interface HoteventsService {

    //查询
    public PageUtil<Hotevents> getHotevents(String keyWord,Integer pageIndex,Integer pageSize);
    //根据id查询信息
    public Hotevents getHoteventsById(Integer id);
}
