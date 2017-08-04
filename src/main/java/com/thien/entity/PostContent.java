package com.thien.entity;


import java.util.Date;

public class PostContent {
    private String title;
    private String content;
    private Date lastMntDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLastMntDate() {
        return lastMntDate;
    }

    public void setLastMntDate(Date lastMntDate) {
        this.lastMntDate = lastMntDate;
    }
}
