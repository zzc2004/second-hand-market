package com.clearcold.market.dao;

import com.clearcold.market.bean.ShoppingCart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartDao {
    @Select("select * from shopping_cart where uid = #{userId}")
    @Results({
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "name", column = "pname"),
    })
    List<ShoppingCart> findByUserId(int userId);

    @Delete("DELETE FROM shopping_cart WHERE uid = #{uid} AND image = #{image}")
    int removeFromCart(@Param("uid") int uid, @Param("image") String image);

    @Insert("INSERT INTO shopping_cart(uid, pid, pname, price, publisher, pquantity, addTime, image) " +
            "VALUES(#{uid}, #{pid}, #{name}, #{price}, #{publisher}, #{quantity}, #{addTime}, #{image})")
    @Results({
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "name", column = "pname"),
    })
    int insertShoppingCart(ShoppingCart cart);

    @Update("UPDATE shopping_cart SET pquantity = #{quantity} WHERE uid = #{uid} AND image = #{image}")
    @Results({
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "name", column = "pname"),
    })
    int updateQuantity(ShoppingCart cart);

    @Delete("DELETE FROM shopping_cart WHERE image = #{image}")
    int deleteByImage(@Param("image") String image);
}
