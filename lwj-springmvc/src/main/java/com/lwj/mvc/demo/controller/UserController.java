package com.lwj.mvc.demo.controller;

import com.lwj.mvc.annotation.*;
import com.lwj.mvc.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Linwj
 * @date 2019/7/12 16:07
 */
@LwjController
@LwjRequstMapping("/lwj")
public class UserController {

    @LwjAutowired
    private UserService userService;

    @LwjRequstMapping("")
    public void println(HttpServletRequest request, HttpServletResponse response, @LwjRequstParam("name")String name){
        try {
            response.getWriter().write(userService.getUserInfo(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
