package com.s3.service.impl;

import com.s3.mapper.CommentsMapper;
import com.s3.mapper.HoteventsMapper;
import com.s3.pojo.Comments;
import com.s3.service.CommentsService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {


    @Resource
    private HoteventsMapper hoteventsMapper;

    @Resource
    private CommentsMapper commentsMapper;

    //根据id查询信息
    @Override
    public List<Comments> getCommentsById(Integer id){
        return commentsMapper.getById(id);
    }

    //新增
    @Override
    public boolean insComments(Comments comments) {
        if (hoteventsMapper.add1(comments.getHotEventsId())>0) {
            return commentsMapper.insert(comments)>0;
        }
        return false;
    }

}
