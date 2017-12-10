package com.mobine.vnews.controller;

import com.alibaba.fastjson.JSON;
import com.mobine.vnews.mapper.UserMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.News;
import com.mobine.vnews.module.bean.User;
import com.mobine.vnews.service.NewsService;
import com.mobine.vnews.service.UserService;
import org.apache.logging.log4j.core.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.apache.logging.log4j.core.config.LoggerConfig.ROOT;
@RestController
@RequestMapping("/vnews/news")
public class NewsController {
    @Autowired
    NewsService newsService;
    @RequestMapping(value="{category}",method = RequestMethod.GET)
    public BasicResponse<List<News>> CategoryNews(@PathVariable("category") String category){
        News news=new News();
        news.setType(category);
        return newsService.categoryNews(news);
    }
}
