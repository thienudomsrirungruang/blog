package com.thien.controller;

import com.thien.entity.Content;
import com.thien.service.ContentGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private ContentGetter contentGetter;

    @RequestMapping("")
    public String getMain(){
        return "main";
    }

    @RequestMapping("/content")
    @ResponseBody
    public List<Content> getContent(){
        return contentGetter.getContent();
    }

    @RequestMapping("/post/{postName}")
    public String getPost(){
        return "post";
    }
}