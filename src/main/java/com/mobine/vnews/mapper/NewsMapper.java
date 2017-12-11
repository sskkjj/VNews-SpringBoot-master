package com.mobine.vnews.mapper;
import com.mobine.vnews.module.bean.News;
import com.mobine.vnews.module.bean.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.mobine.vnews.module.bean.record_news;
import org.apache.ibatis.annotations.*;
import com.mobine.vnews.module.bean.view_news;
import com.mobine.vnews.module.bean.favorite_news;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public  interface NewsMapper{
    @Select("SELECT ID,title,author,description,image,publishedAt,source,content,level,type FROM news ")
    List<News> getAllNews(News news);
    @Select("SELECT ID,title,author,description,image,publishedAt,source,content,level,type FROM news WHERE type=#{type}")
    List<News> getNewsByType(News news);
    @Select("SELECT newsID FROM view_news ORDER BY count DESC")
    List<view_news> hotNews();
    @Select("SELECT ID,title,author,description,image,publishedAt,source,content,level,type FROM news WHERE ID=#{newsID}")
    News getNewsByViewNewsID(view_news news);
    @Select("SELECT ID,title,author,description,image,publishedAt,source,content,level,type FROM news WHERE ID=#{ID}")
    News getNewsByNewsID(News news);
    @Select("SELECT newsID FROM like_news WHERE userID=#{userID}")
    List<favorite_news>  getFavoriteNewsID(favorite_news news);
    @Select("SELECT ID,title,author,description,image,publishedAt,source,content,level,type FROM news WHERE ID=#{newsID}")
    News getNewsByFavoriteNewsID(favorite_news news);
    @Insert("INSERT INTO like_news (userID,newsID) VALUES (#{userID},#{newsID})")
    int addFavoriteNews(favorite_news news);
    @Select("SELECT userID,newsID FROM like_news WHERE userID=#{userID} AND newsID=#{newsID}")
    favorite_news checkFavoriteNews(favorite_news news);
    @Delete("DELETE FROM like_news WHERE userID=#{userID} AND newsID=#{newsID}")
    int deleteFavoriteNews(favorite_news news);
    @Select("SELECT newsID FROM record_news WHERE newsID=#{newsID}")
    record_news checkViewedNews(record_news news);
}

