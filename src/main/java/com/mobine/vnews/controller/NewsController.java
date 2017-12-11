package com.mobine.vnews.controller;

import com.alibaba.fastjson.JSON;
import com.mobine.vnews.mapper.UserMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.*;
import com.mobine.vnews.service.NewsService;
import com.mobine.vnews.service.UserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
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
    @RequestMapping(value="",method = RequestMethod.GET)
    public BasicResponse<List<News>> allCategoryNews(@RequestParam("start")int start,@RequestParam("count")int count){
        News news=new News();
        news.setType("");
        return newsService.categoryNews(news,start,count);
    }
    @RequestMapping(value="{category}",method = RequestMethod.GET)
    public BasicResponse<List<News>> CategoryNews(@PathVariable("category") String category,@RequestParam("start")int start,@RequestParam("count")int count){
        News news=new News();
        news.setType(category);
        return newsService.categoryNews(news,start,count);
    }
    @RequestMapping(value="/hots",method = RequestMethod.GET)
    public BasicResponse<List<News>> hotNews(@RequestParam("count") int count){
        return newsService.hotNews(count);
    }
    @RequestMapping(value="/detail/{news_id}",method = RequestMethod.GET)
    public BasicResponse<News> detail(@PathVariable("news_id") int ID){
        News news=new News();
        news.setID(ID);
        return newsService.detail(news);
    }
    @RequestMapping(value="/{user_id}/likes",method = RequestMethod.GET)
    public BasicResponse<List<News>> favoriteNews(@PathVariable("user_id") String user_id,@RequestParam("category")String category, @RequestParam("start") int start,@RequestParam("count") int count){
        favorite_news news=new favorite_news();
        news.setUserID(user_id);
        return newsService.favoriteNews(news,start,count,category);
    }
    @RequestMapping(value="/{user_id}/like/{news_id}",method = RequestMethod.POST)
    public BasicResponse<String> addFavoriteNews(@PathVariable("user_id") String user_id,@PathVariable("news_id") int news_id){
        favorite_news news=new favorite_news();
        news.setUserID(user_id);
        news.setNewsID(news_id);
        return newsService.addFavoriteNews(news);
    }
    @RequestMapping(value="/{user_id}/like/{news_id}",method = RequestMethod.GET)
    public BasicResponse<String> checkFavoriteNews(@PathVariable("user_id") String user_id,@PathVariable("news_id") int news_id){
        favorite_news news=new favorite_news();
        news.setUserID(user_id);
        news.setNewsID(news_id);
        return newsService.checkFavoriteNews(news);
    }
    @RequestMapping(value="/{user_id}/like/{news_id}",method = RequestMethod.DELETE)
    public BasicResponse<String> deleteFavoriteNews(@PathVariable("user_id") String user_id,@PathVariable("news_id") int news_id){
        favorite_news news=new favorite_news();
        news.setUserID(user_id);
        news.setNewsID(news_id);
        return newsService.deleteFavoriteNews(news);
    }
    @RequestMapping(value = "/view/{news_id}",method = RequestMethod.POST)
    public BasicResponse<String> checkViewedNews(@PathVariable("news_id") int news_id){
        record_news news=new record_news();
        news.setNewsID(news_id);
        return  newsService.checkViewedNews(news);
    }
}
