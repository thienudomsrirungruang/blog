package com.thien.service;

import com.thien.entity.Content;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentGetter {
    public List<Content> getContent() {
        return null;
    }

    public Content buildContent(String title, String contentPreview ){
        Content content = new Content();
        content.setTitle(title);
        content.setContent(contentPreview);
        content.setLastMntDate(new Date());
        return content;
    }
}
