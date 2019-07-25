package com.lwj.jdbctemplate.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author Linwj
 * @date 2019/7/24 15:41
 */
@Data
@Table(name = "product")
public class Product {
    private Integer id;
    @Column(name = "productCost")
    private String productCost;
    private String productName;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNo='" + productCost + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
