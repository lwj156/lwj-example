package com.lwj.mybatis.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Linwj
 * @date 2019/7/26 10:11
 */
public class User implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
