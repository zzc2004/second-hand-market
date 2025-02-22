package com.clearcold.market.util;

import java.sql.*;
import java.util.Properties;
import java.util.regex.Pattern;

public class JDBCUtil {
    private static final String GREATER_NUMBER_REGEX = "[0-9]{0,9}";//匹配正整数
    private static final String PRICE_REGEX = "^(\\+)?\\d+(\\.\\d+)?$";//匹配正数和小数
    private static final String NUMBER_REGEX = "-?[0-9]{0,9}";//匹配正数和负数
    private static final String TELEPHONENUMBER_REGEX = "^1[3-9]\\d{9}$";//匹配电话号
    private static final String NAME_REGEX = "^[\\u4e00-\\u9fa5.·\\u36c3\\u4DAE]{0,}$";//匹配姓名
    private static final String ONE_OR_TWO = "^[12]$";//匹配1或2
    private static final String USERNAME_REGEX = "^[0-9a-zA-Z]{8,18}$";//匹配用户名格式

    public static boolean isValidGreaterNumber(String str) {
        return Pattern.compile(GREATER_NUMBER_REGEX).matcher(str).matches();
    }//判断是否为有效的正数
    public static boolean isOne(String str) {
        return Pattern.compile("1").matcher(str).matches();
    }//判断是否为1
    public static boolean isValidPrice(String str) {
        return Pattern.compile(PRICE_REGEX).matcher(str).matches();
    }//是否为合法小数
    public static boolean isValidNumber(String str) {
        return Pattern.compile(NUMBER_REGEX).matcher(str).matches();
    }//是否为有效正数
    public static boolean isTelephoneNumber(String str) {
        return Pattern.compile(TELEPHONENUMBER_REGEX).matcher(str).matches();
    }//判断是否为电话号
    public static boolean isName(String str) {
        return Pattern.compile(NAME_REGEX).matcher(str).matches();
    }//判断是否为合法姓名
    public static boolean isOneOrTwo(String str) {
        return Pattern.compile(ONE_OR_TWO).matcher(str).matches();
    }//判断是否为1或2
    public static boolean isUsername(String str) {
        return Pattern.compile(USERNAME_REGEX).matcher(str).matches();
    }//判断是否为合法用户名
    public static Connection getConnection(){
        try {
            Properties properties = new Properties();
//            properties.load(new FileInputStream("configs\\config.properties"));
            String url = "jdbc:mysql://localhost:3306/market";
            String user = "root";
            String password = "123456";
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 创建连接
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }//获取连接
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


