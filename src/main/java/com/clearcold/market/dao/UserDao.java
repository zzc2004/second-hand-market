package com.clearcold.market.dao;

import com.clearcold.market.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface UserDao {
    @Select("select * from users where username=#{username} and password=#{password}")
    @Results({
            @Result(property = "id", column = "uid"),
            @Result(property = "name", column = "uname"),
            @Result(property = "sex", column = "usex"),
            @Result(property = "birthday", column = "ubirthday"),
            @Result(property = "type", column = "utype"),
            @Result(property = "tel", column = "utel")
    })
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    @Update("UPDATE users SET uname=#{name}, utel=#{tel}, email=#{email}, signature=#{signature} WHERE uid=#{id}")
    int updateUser(User user);
    @Update("UPDATE users " +
            "        SET password=#{newPass} " +
            "        WHERE uid=#{id} AND password=#{oldPass}")
    int updatePassword(@Param("id") Integer id, @Param("newPass") String newPass, @Param("oldPass") String oldPass);
    @Update("UPDATE users SET balance = balance - #{amount} WHERE uid = #{uid}")
    int updateBalance(@Param("uid") int uid, @Param("amount") double amount);

    @Insert("INSERT INTO users (username, password, uname, utel,email, usex, balance,ubirthday,utype,image) " +
            "VALUES (#{username}, #{password}, #{name}, #{phone},#{email}, #{gender},0.0,#{birthdate},2," +
            "'/static/images/head/default.jpg')")
    @Results({
            @Result(property = "name", column = "uname"),
            @Result(property = "gender", column = "usex"),
            @Result(property = "birthdate", column = "ubirthday"),
            @Result(property = "type", column = "utype"),
            @Result(property = "phone", column = "utel")
    })
    boolean register(@Param("username") String username, @Param("password") String password, @Param("name") String name,
                     @Param("phone") String phone, @Param("email") String email,@Param("gender") String gender,
                     @Param("birthdate") String birthdate);

    @Select("select * from users where uid=#{uid}")
    @Results({
            @Result(property = "id", column = "uid"),
            @Result(property = "name", column = "uname"),
            @Result(property = "sex", column = "usex"),
            @Result(property = "birthday", column = "ubirthday"),
            @Result(property = "type", column = "utype"),
            @Result(property = "tel", column = "utel")
    })
    User getUserById(@Param("uid") int uid);
}
