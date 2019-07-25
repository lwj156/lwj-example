package com.lwj.jdbctemplate.entity;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @author Linwj
 * @date 2019/7/24 14:28
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
