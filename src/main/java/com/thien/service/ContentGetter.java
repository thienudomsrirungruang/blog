package com.thien.service;

import com.thien.dao.ContentDao;
import com.thien.entity.Content;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContentGetter {
    private boolean hasContent = false;
    private List<Content> content;
    private ContentDao cd;

    public ContentGetter(){
        cd = ContentDao.getInstance();
    }

    public List<Content> getContent() {
        if(hasContent){
            return content;
        }
        ResultSet rs = cd.getContent();
        if(rs != null) {
            ArrayList<Content> output = new ArrayList<>();
            try {
                while (rs.next()) {
                    output.add(buildContent(rs.getString(2), rs.getString(3), rs.getDate(4)));
                }
            } catch (SQLException e) {
                return null;
            }
            content = output;
            return content;
        }else{
            return null;
        }
    }

    public Content buildContent(String title, String contentPreview, Date date){
        Content content = new Content();
        content.setTitle(title);
        content.setContent(contentPreview);
        content.setLastMntDate(date);
        return content;
    }
}
