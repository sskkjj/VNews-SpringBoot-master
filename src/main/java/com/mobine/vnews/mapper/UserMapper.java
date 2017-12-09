package com.mobine.vnews.mapper;

import com.mobine.vnews.module.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user (ID, username, password, telephone) VALUES (#{ID},#{username},#{password},#{telephone})")
    int addUser(User user);

    @Select("SELECT username, password FROM user WHERE username = #{username} and password = #{password}")
    User findUserByUsername(User user);

    @Select("SELECT username, password FROM user WHERE telephone = #{telephone} and password = #{password}")
    User findUserByTelephone(User user);

    @Delete("DELETE FROM user WHERE username = #{username}")
    int removeUserByUsername(User user);

    @Delete("DELETE FROM user WHERE username = #{username}")
    int removeUserByTelaphone(User user);

}
