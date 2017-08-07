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
    private ContentDao cd;

    public ContentGetter(){
        cd = ContentDao.getInstance();
    }

    public List<Content> getPage(int page){
        ResultSet postContent = cd.getContentInRange((page - 1) * 10, 10);;
        ArrayList<Content> output = new ArrayList<>();
        try {
            while(postContent.next()){
                output.add(buildContent(postContent.getInt(1), postContent.getString(2), postContent.getString(3), postContent.getDate(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    public Content getContentById(int id){
        ResultSet rs = cd.getContentById(id);
        try {
            return buildContent(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Content buildContent(int id, String title, String text, Date date){
        Content content = new Content();
        content.setId(id);
        content.setTitle(title);
        content.setContent(text);
        content.setLastMntDate(date);
        return content;
    }
}
