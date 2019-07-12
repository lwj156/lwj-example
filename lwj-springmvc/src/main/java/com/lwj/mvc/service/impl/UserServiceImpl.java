package com.lwj.mvc.service.impl;

import com.lwj.mvc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author Linwj
 * @date 2019/7/12 16:12
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getUserInfo(String name) {
        return name;
    }
}
