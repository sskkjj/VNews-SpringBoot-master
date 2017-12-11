package com.mobine.vnews.controller;

import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.*;
import com.mobine.vnews.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("vnews/news")
public class CommentController {
    @Autowired
    CommentService commentService;
    /*@RequestMapping(value = "comment",method = RequestMethod.POST)
    该函数不需要
    public BasicResponse<String> addComment(@RequestParam("news_id")int news_id,@RequestParam("username") String username,@RequestParam("to_user_id")String to_user_id){
        Comment comment=new Comment();
        comment.setNewsID(news_id);
        comment.setUsername(username);
        comment.setToID(to_user_id);
        return commentService.addComment(comment);
    }*/
    @RequestMapping(value = "comments/{news_id}",method =RequestMethod.GET)
    public BasicResponse<List<Comment>> getComment(@PathVariable("news_id") int news_id,@RequestParam("start")int start,@RequestParam("count")int count){
        Comment conment=new Comment();
        conment.setNewsID(news_id);
        return commentService.getComment(conment,start,count);
    }
    @RequestMapping(value="comment/{comment_id}/like",method = RequestMethod.GET)
    public BasicResponse<String> likeComment(@PathVariable("comment_id")int comment_id,@RequestParam("user_id") String user_id){
        like_comment comment=new like_comment();
        comment.setUser_id(user_id);
        comment.setConment_id(comment_id);
        return commentService.likeComment(comment);
    }
    @RequestMapping(value="comment/{comment_id}/like",method = RequestMethod.DELETE)
    public BasicResponse<String> dislikeComment(@PathVariable("comment_id")int comment_id,@RequestParam("user_id") String user_id){
        like_comment comment=new like_comment();
        comment.setUser_id(user_id);
        comment.setConment_id(comment_id);
        return commentService.dislikeComment(comment);
    }
}
