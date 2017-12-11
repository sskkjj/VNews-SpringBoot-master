package com.mobine.vnews.mapper;
import com.mobine.vnews.module.bean.*;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PreferenceMapper {
    @Insert("INSERT INTO user_preference (userID,typeID,preference) VALUES(#{userID},#{typeID},#{preference})")
    int addPreference (userPreference user_preference);
    @Select("SELECT userID,typeID,preference FROM user_preference WHERE userID=#{userID}")
    List<userPreference> getPreference(userPreference user_preference);
    @Delete("DELETE FROM user_preference WHERE userID=#{userID}")
    int deletePreference(userPreference userPreference);
}
