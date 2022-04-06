package com.s3.service;

import com.s3.pojo.Comments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface CommentsService {

    //根据id查询信息
    public List<Comments> getCommentsById(Integer id);
    //新增评论
    public boolean insComments(Comments comments);

}
