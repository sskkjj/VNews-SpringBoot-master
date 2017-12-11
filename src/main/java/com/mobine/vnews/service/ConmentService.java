package com.mobine.vnews.service;

import com.mobine.vnews.mapper.ConmentMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConmentService {
    @Autowired
    ConmentMapper conmentMapper;
    public BasicResponse<String> addConment(Comment conment){
        BasicResponse<String> response=new BasicResponse<>();
        return response;
    }
    public BasicResponse<List<Comment>> getConment(Comment conment,int start,int count){
        BasicResponse<List<Comment>> response=new BasicResponse<>();
        int code=200;
        String message="return conments success";
        try{
            List<Comment> conments=conmentMapper.getComment(conment);
            ArrayList<Comment> selectedConments=new ArrayList<>();
            if(conments.isEmpty()){
                code=400;
                message="fail to get the news' conments";
            }
            for(int i=start;i<count;i++){
                selectedConments.add(conments.get(i));
            }
            response.setContent(selectedConments);
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
        String message="thumb up the conment success";
        try{
            int res=conmentMapper.likeComment(comment);
            if(res==0){
                code=400;
                message="fail to thumb up the conment";
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
}
