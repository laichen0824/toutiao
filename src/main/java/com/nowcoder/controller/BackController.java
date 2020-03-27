package com.nowcoder.controller;

import com.alibaba.fastjson.JSON;
import com.nowcoder.service.CommentService;
import com.nowcoder.service.NewsService;
import com.nowcoder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class BackController {
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @Autowired
    NewsService newsService;

    @RequestMapping("/toBack")
    public String toBack(){
        return "/background/background";
    }

    @RequestMapping("/back")
    public String toIndex(){
        return "background/back";
    }
    @RequestMapping("/toComment")
    public String toComment(){
        return "background/comment";
    }

    @RequestMapping("/toUser")
    public String toUser(){
        return "/background/user";
    }

    @RequestMapping("/toNews")
    public String toNews(){
        return "background/news";
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public Map<String,Object> show(@RequestParam(required = false,defaultValue = "") String name, int limit, int page){
        return userService.queryUserList(name,page,limit);
    }

    @RequestMapping(path = {"/deleteUser/{id}"}, method = {RequestMethod.GET})
    @ResponseBody
    public Object deleteUser(@PathVariable("id") int id){
        if(userService.deleteUser(id)>0){
            return JSON.toJSONString("true");
        }
        return JSON.toJSONString("false");
    }

    @RequestMapping("/showNews")
    @ResponseBody
    public Map<String,Object> showNews(@RequestParam(value = "name",required = false,defaultValue = "") String name, int limit, int page){
        return newsService.getNewsList(name, page, limit);
    }

    @RequestMapping("/showComment")
    @ResponseBody
    public Map<String,Object> showComment(@RequestParam(required = false,defaultValue = "") String name, int limit, int page){
        return commentService.queryComment(name,page,limit);
    }

    @RequestMapping(path = {"/deleteComment/{id}"}, method = {RequestMethod.GET})
    @ResponseBody
    public Object deleteComment(@PathVariable("id") int id){
        if(commentService.deleteComment(id)>0){
            return JSON.toJSONString("true");
        }
        return JSON.toJSONString("false");
    }

}
