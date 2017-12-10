package com.mobine.vnews.service;
import com.alibaba.fastjson.JSONObject;
import com.mobine.vnews.mapper.NewsMapper;
import com.mobine.vnews.mapper.UserMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.News;
import com.mobine.vnews.module.bean.view_news;
import com.mobine.vnews.module.bean.User;
import com.mobine.vnews.util.IdUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.awt.geom.AreaOp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class NewsService {
    @Autowired
    NewsMapper newsMapper;
    private static  Logger log=LogManager.getLogger(NewsService.class);
    public BasicResponse<List<News>>  categoryNews(News news){
        BasicResponse<List<News>> response=new BasicResponse<>();
        int code=200;
        String message="get category news success";
        try{
            List<News> allInfo=newsMapper.getNewsByType(news);
            if(allInfo.isEmpty()){
                code=400;
                message="category doesn't exist";
            }
            response.setContent(allInfo);
        } catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
    public BasicResponse<List<News>> hotNews(int count){
        BasicResponse<List<News>>response=new BasicResponse<>();
        int code=200;
        String message="get hot news success";
        try{
            List<view_news> allNews=newsMapper.hotNews();
            ArrayList<News> hotnews=new ArrayList<>();
            for(int i=0;i<count;i++){
                hotnews.add(newsMapper.getNewsByID(allNews.get(i)));
            }
            response.setContent(hotnews);
        }catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return  response;
    }
    public BasicResponse<News> detail(News news){
        BasicResponse<News> response=new BasicResponse<>();
        int code=200;
        String message="success";
        try{
            News info=newsMapper.getNewsByNewID(news);
            if(info==null){
                code=400;
                message="cannot find the news_id";
            }else{
                response.setContent(info);
            }
        }catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return  response;
    }
}
