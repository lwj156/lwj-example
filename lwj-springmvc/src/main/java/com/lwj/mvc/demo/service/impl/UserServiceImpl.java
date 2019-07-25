package com.lwj.mvc.demo.service.impl;

import com.lwj.mvc.annotation.LwjService;
import com.lwj.mvc.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Linwj
 * @date 2019/7/12 16:12
 */
@LwjService
public class UserServiceImpl implements UserService {
    @Override
    public String getUserInfo(String name) {
        return name;
    }
}
