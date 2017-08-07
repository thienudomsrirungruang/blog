package com.thien.controller;

import com.thien.entity.Content;
import com.thien.service.ContentGetter;
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



    @RequestMapping("")
    public String getMain(){
        return "main";
    }

    @RequestMapping("/page/{pageNumber}")
    public String getResultPage(){
        return "main";
    }

    @RequestMapping(value = "/content-preview", method = RequestMethod.POST)
    @ResponseBody
    public List<Content> getContentPreview(@RequestParam int page){
        return contentGetter.getPage(page);
    }

    @RequestMapping("/post/{postId}")
    public String getPost(){
        return "post";
    }

    @RequestMapping(value = "/post-info", method = RequestMethod.POST)
    @ResponseBody
    public Content getPostContent(@RequestParam String idString){
        try{
           int id = Integer.parseInt(idString);
           return contentGetter.getContentById(id);
        }catch(NumberFormatException e){
            return null;
        }
    }
}
