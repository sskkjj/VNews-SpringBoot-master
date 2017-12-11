package com.mobine.vnews.mapper;
import com.mobine.vnews.module.bean.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CommentMapper {
    @Select("SELECT ID,fromID,toID,content,timestamp,newsID,floor FROM comment WHERE newsID=#{newsID} ORDER BY floor ASC")
    List<Comment>getComment(Comment comment);
    @Insert("INSERT INTO like_comment (userID,commentID) VALUES (#{user_id},#{comment_id})")
    int likeComment(like_comment comment);
    @Delete("DELETE FROM like_comment WHERE userID=#{user_id} AND commentID=#{comment_id}")
    int dislikeComment(like_comment comment);
}
