package com.thien.service;

import com.thien.entity.PostContent;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MockPostContent {
    public PostContent getPostContent(){
        PostContent output = new PostContent();
        output.setContent("Content test");
        output.setTitle("Title test");
        output.setLastMntDate(new Date());
        return output;
    }
}
