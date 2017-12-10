package com.mobine.vnews.service;
import com.alibaba.fastjson.JSONObject;
import com.mobine.vnews.mapper.NewsMapper;
import com.mobine.vnews.mapper.UserMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.News;
import com.mobine.vnews.module.bean.User;
import com.mobine.vnews.util.IdUtils;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
            List<News> allInfo=newsMapper.categoryNews(news);
            response.setContent(allInfo);
        } catch (Exception e){
            code=400;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
