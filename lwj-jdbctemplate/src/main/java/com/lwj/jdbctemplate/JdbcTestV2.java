package com.lwj.jdbctemplate;

import com.lwj.jdbctemplate.entity.Product;
import com.lwj.jdbctemplate.entity.User;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.File;
import java.lang.reflect.Field;
import java.sql.*;
import java.time.OffsetDateTime;
import java.util.*;

/**
 * @author Linwj
 * @date 2019/7/24 14:17
 */
public class JdbcTestV2 {

    public static void main(String[] args) {
        User user=new User();
        user.setAge(23);
        List<Object> userExcute = excute(user);
        List<Object> orderExcute = excute(new Product());
        System.out.println(userExcute.toString());
        System.out.println(orderExcute.toString());
    }

    private static <T> List<T> excute(T object) {
        //连接
        Connection conn = null;
        //语句集
        PreparedStatement pstm = null;
        //结果集
        ResultSet rs = null;

        StringBuilder sql = new StringBuilder("select * from ");

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        //where语句的拼接  可不用
        Map<String, String> fieldRcolumn = new HashMap<>();
        //结果集匹配
        Map<String, String> columnRfield = new HashMap<>();
        //返回对象集合
        List<T> userList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lwj_jdbctemplate?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false", "root", "");

            String tableName = toLowCast(clazz.getSimpleName());
            if (clazz.isAnnotationPresent(Table.class)) {
                Table table = clazz.getAnnotation(Table.class);
                tableName = table.name();
            }

            sql.append(tableName).append(" where 1=1 ");

            //sql拼接
            for (Field field : fields) {
                //安全校验
                field.setAccessible(true);
                String columnName = field.getName();
                if (field.isAnnotationPresent(Column.class)) {
                    Column column = field.getAnnotation(Column.class);
                    columnName = column.name();
                }
                fieldRcolumn.put(field.getName(), columnName);
                columnRfield.put(columnName, field.getName());
                Object value = field.get(object);
                if (value != null) {
                    sql.append(" and ").append(columnName).append(" = ").append(value);
                }
            }

            pstm = conn.prepareStatement(String.valueOf(sql));
            rs = pstm.executeQuery();

            //结果集处理
            while (rs.next()) {
                Object res = clazz.newInstance();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    String columnName = rs.getMetaData().getColumnLabel(i);
                    Field field = clazz.getDeclaredField(columnRfield.get(columnName));
                    field.setAccessible(true);
                    field.set(res, rs.getObject(columnName));
                }
                userList.add((T) res);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * 首字母转小写 自用
     *
     * @param source
     */
    private static String toLowCast(String source) {
        char[] chars = source.toCharArray();
        chars[0] += 32;
        return new String(chars);
    }
}
