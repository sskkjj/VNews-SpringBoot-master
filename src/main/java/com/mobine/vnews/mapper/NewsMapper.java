package com.mobine.vnews.mapper;
import com.mobine.vnews.module.bean.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public  interface NewsMapper{
    @Select("SELECT ID,title,author,description,image,publishedAt,source,content,level,type FROM news WHERE type=#{type}")
    List<News> categoryNews(News news);
}

