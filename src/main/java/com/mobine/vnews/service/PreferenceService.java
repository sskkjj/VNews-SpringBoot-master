package com.mobine.vnews.service;
import com.mobine.vnews.mapper.CommentMapper;
import com.mobine.vnews.mapper.PreferenceMapper;
import com.mobine.vnews.module.BasicResponse;
import com.mobine.vnews.module.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PreferenceService {
    @Autowired
    PreferenceMapper preferenceMapper;
}
