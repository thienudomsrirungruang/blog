package com.thien.controller;

import com.thien.entity.Content;
import com.thien.entity.PostContent;
import com.thien.service.ContentGetter;
import com.thien.service.MockPostContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private ContentGetter contentGetter;

    @Autowired
    private MockPostContent mpc;


    @RequestMapping("")
    public String getMain(){
        return "main";
    }

    @RequestMapping("/content-preview")
    @ResponseBody
    public List<Content> getContentPreview(){
        return contentGetter.getContent();
    }

    @RequestMapping("/post/{postName}")
    public String getPost(){
        return "post";
    }

    @RequestMapping(value = "/post-info", method = RequestMethod.POST)
    @ResponseBody
    public PostContent getPostContent(@RequestParam int id){
        return mpc.getPostContent();
    }
}
