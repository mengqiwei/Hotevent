package com.s3.controller;

import com.s3.pojo.Comments;
import com.s3.pojo.Hotevents;
import com.s3.service.CommentsService;
import com.s3.service.HoteventsService;
import com.s3.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class HoteventsController {

    @Resource
    private HoteventsService hoteventsService;

    @Resource
    private CommentsService commentsService;
    //ajax分页
    @RequestMapping("/showAjax")
    @ResponseBody
    public PageUtil<Hotevents> showAjax(
            @RequestParam(value = "keyWord",defaultValue = "")String keyWord,
            @RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex
    ){
        return hoteventsService.getHotevents(keyWord, pageIndex, 3);

    }
    //ajax查询单个新闻
    @RequestMapping("/info/{id}")
    public String info(
            @PathVariable("id")Integer id,
            Model model
    ) {
        model.addAttribute("id", id);
        return "toAll";
    }

    //ajax查询单个新闻
    @RequestMapping("/showinfo")
    @ResponseBody
    public Hotevents showinfo(
            @RequestParam("id")Integer id
    ){
        return hoteventsService.getHoteventsById(id);
    }

    //ajax查询评论
    @RequestMapping("/showinfoAll")
    @ResponseBody
    public List<Comments> showinfoAll(
            @RequestParam("id")Integer id
    ){
        return commentsService.getCommentsById(id);
    }
    //新增
    @RequestMapping("/insert")
    public String insert(Comments comments){
        if (commentsService.insComments(comments)) {
            return "index";
        }
        return "index";
    }

}
