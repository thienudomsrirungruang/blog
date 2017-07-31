package com.thien.service;

import com.thien.entity.Content;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Deprecated
public class MockContent {

    public List<Content> getMockContent(){
        List<Content> contentList = new ArrayList<Content>();
        contentList.add(buildContent("Test", "Content"));
        contentList.add(buildContent("Test1", "Content1"));
        contentList.add(buildContent("Test2", "Content2"));
        contentList.add(buildContent("Test3", "Content3"));
        contentList.add(buildContent("Test4", "Content4"));
        contentList.add(buildContent("Test5", "Content5"));
        contentList.add(buildContent("Test6", "Content6"));
        contentList.add(buildContent("Test7", "Content7"));

        return contentList;
    }

    public Content buildContent(String title, String contentPreview ){
        Content content = new Content();
        content.setTitle(title);
        content.setContent(contentPreview);
        content.setLastMntDate(new Date());
        return content;
    }
}
