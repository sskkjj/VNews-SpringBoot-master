package com.mobine.vnews.service;
import com.alibaba.fastjson.JSONObject;
import com.mobine.vnews.mapper.NewsMapper;
import com.mobine.vnews.mapper.UserMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.News;
import com.mobine.vnews.module.bean.view_news;
import com.mobine.vnews.module.bean.favorite_news;
import com.mobine.vnews.module.bean.User;
import com.mobine.vnews.util.IdUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sun.awt.geom.AreaOp;

import javax.xml.ws.Response;
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
                hotnews.add(newsMapper.getNewsByViewNewsID(allNews.get(i)));
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
            News info=newsMapper.getNewsByNewsID(news);
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
    public BasicResponse<List<News>> favoriteNews(favorite_news news,int start,int count,String category){
        BasicResponse<List<News>> response=new BasicResponse<>();
        int code=200;
        String message="get favorite news success";
        try{
            List<favorite_news> newsContainer= newsMapper.getFavoriteNewsID(news);
            ArrayList<News>newsInfo=new ArrayList<News>();
            for(int i=0;i<newsContainer.size();i++){
                News element=newsMapper.getNewsByFavoriteNewsID(newsContainer.get(i));
                if(category.equals(element.getType())){
                    newsInfo.add(element);
                }
            }
            ArrayList<News>selectedInfo=new ArrayList<News>();
            for(int i=start;i<start+count;i++){
                selectedInfo.add(newsInfo.get(i));
            }
            response.setContent(selectedInfo);
        }catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return  response;
    }
    public BasicResponse<String> addFavoriteNews(favorite_news news){
        BasicResponse<String>response=new BasicResponse<>();
        int code=200;
        String message="add favorite news success";
        try{
            int res=newsMapper.addFavoriteNews(news);
            if(res==0){
                code=400;
                message="cannot add favorite news";
            }
        }catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        response.setContent("");
        return  response;
    }
    public  BasicResponse<String> checkFavoriteNews(favorite_news news){
        BasicResponse<String> response=new BasicResponse<>();
        int code=200;
        String message="favorite news exists";
        try{
            favorite_news res=newsMapper.checkFavoriteNews(news);
            if(res==null){
                code=400;
                message="favorite news does not exist";
            }
        }catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        response.setContent("");
        return  response;
    }
    public  BasicResponse<String> deleteFavoriteNews(favorite_news news){
        BasicResponse<String> response=new BasicResponse<>();
        int code=200;
        String message="delete favorite news success";
        try{
            int res=newsMapper.deleteFavoriteNews(news);
            if(res==0){
                code=400;
                message="fail to delete favorite news";
            }
        }catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        response.setContent("");
        return  response;
    }
}
