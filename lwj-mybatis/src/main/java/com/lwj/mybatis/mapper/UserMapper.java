package com.lwj.mybatis.mapper;

import com.lwj.mybatis.entity.User;

import java.util.List;

/**
 * @author Linwj
 * @date 2019/7/26 10:11
 */
public interface UserMapper {
    User selectUser(Integer id);
    List<User> selectAll();

}
