package com.mobine.vnews.service;

import com.mobine.vnews.mapper.CommentMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    public BasicResponse<String> addComment(Comment comment){
        BasicResponse<String> response=new BasicResponse<>();
        return response;
    }
    public BasicResponse<List<Comment>> getComment(Comment comment,int start,int count){
        BasicResponse<List<Comment>> response=new BasicResponse<>();
        int code=200;
        String message="return comments success";
        try{
            List<Comment> comments= commentMapper.getComment(comment);
            ArrayList<Comment> selectedComments=new ArrayList<>();
            if(comments.isEmpty()){
                code=400;
                message="fail to get the news' comments";
            }
            for(int i=start;i<count;i++){
                selectedComments.add(comments.get(i));
            }
            response.setContent(selectedComments);
        }catch (Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        return  response;
    }
    public BasicResponse<String> likeComment(like_comment comment){
        BasicResponse<String> response=new BasicResponse<>();
        int code=200;
        String message="thumb up the comment success";
        try{
            int res= commentMapper.likeComment(comment);
            if(res==0){
                code=400;
                message="fail to thumb on the comment";
            }
        }catch ( Exception e){
            code=500;
            message=e.getMessage();
        }
        response.setCode(code);
        response.setMessage(message);
        response.setContent("");
        return  response;
    }
    public BasicResponse<String>dislikeComment(like_comment comment){
        BasicResponse<String>response=new BasicResponse<>();
        int code=200;
        String message="cancel thumb on the comment success";
        try{
            int res= commentMapper.dislikeComment(comment);
            if(res==0){
                code=400;
                message="fail to cancel thumb on the comment";
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
