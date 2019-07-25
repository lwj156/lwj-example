package com.lwj.jdbctemplate;

import com.lwj.jdbctemplate.entity.Product;
import com.lwj.jdbctemplate.entity.User;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Linwj
 * @date 2019/7/24 14:17
 */
public class JdbcTestV1 {

    public static void main(String[] args) {
        List<Object> userExcute = excute(new User());
        List<Object> orderExcute = excute(new Product());
        System.out.println(userExcute.toString());
        System.out.println(orderExcute.toString());
    }

    private static <T> List<T> excute(T object){
        //连接
        Connection conn=null;
        //语句集
        PreparedStatement pstm=null;
        //结果集
        ResultSet rs=null;

        Class<?> clazz=object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        List<T> userList=new ArrayList<>();



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/lwj_jdbctemplate?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false","root","");
            pstm=conn.prepareStatement("select * from "+toLowCast(clazz.getSimpleName()));
            rs=pstm.executeQuery();
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()){
//                User user=new User();
//                user.setId(rs.getInt("id"));
//                user.setAge(rs.getInt("age"));
//                user.setUserName(rs.getString("userName"));
//                System.out.println(user.toString());
                T result= (T) clazz.newInstance();
                for (Field field : fields) {
                    //权限设置
                    field.setAccessible(true);
                    field.set(result,rs.getObject(field.getName()));
                }
                userList.add(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                pstm.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    /**
     * 首字母转小写
     * @param source
     */
    private static String toLowCast(String source){
        char[] chars = source.toCharArray();
        chars[0]+=32;
        return new String(chars);
    }
}
