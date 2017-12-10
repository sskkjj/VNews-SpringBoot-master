package com.mobine.vnews.mapper;
import com.mobine.vnews.module.bean.News;
import com.mobine.vnews.module.bean.User;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.annotations.*;
import com.mobine.vnews.module.bean.view_news;
import com.mobine.vnews.module.bean.favorite_news;
import java.util.List;

@Mapper
public  interface NewsMapper{
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
}

