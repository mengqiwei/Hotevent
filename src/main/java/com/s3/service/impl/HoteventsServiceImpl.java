package com.s3.service.impl;

import com.s3.mapper.HoteventsMapper;
import com.s3.pojo.Hotevents;
import com.s3.service.HoteventsService;
import com.s3.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class HoteventsServiceImpl implements HoteventsService {

    @Resource
    private HoteventsMapper hoteventsMapper;
    //查询
    @Override
    public PageUtil<Hotevents> getHotevents(String keyWord, Integer pageIndex, Integer pageSize){
        PageUtil<Hotevents> page=new PageUtil<>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalCount(hoteventsMapper.getCount(keyWord));
        page.setList(hoteventsMapper.getPage(keyWord,(pageIndex-1)*pageSize,pageSize));
        return page;
    }

    //根据id查询
    @Override
    public Hotevents getHoteventsById(Integer id) {
        return hoteventsMapper.getById(id);
    }

}
