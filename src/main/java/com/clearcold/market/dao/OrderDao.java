package com.clearcold.market.dao;

import com.clearcold.market.bean.Order;
import com.clearcold.market.bean.ShoppingCart;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    @Select("select * from orders where status = '正常'")
    @Results({
            @Result(property = "price", column = "totalPrice"),
    })
    List<Order> findAllOrders();

    @Insert("INSERT INTO orders(pid,uid,quantity,totalPrice,time,status) VALUES(#{pid},#{uid},#{quantity},#{price},#{time},#{status})")
    @Results({
            @Result(property = "price", column = "totalPrice"),
    })
    int createOrder(Order order);
    @Update("UPDATE orders SET status = '已删除' WHERE oid = #{oid}")
    boolean deleteOrder(@Param("oid") int oid);

    @Select("SELECT o.*, u.username AS userName, p.pname AS productName " +
            "FROM orders o " +
            "JOIN user u ON o.uid = u.uid " +
            "JOIN product p ON o.pid = p.pid")
    @Results({
            @Result(property = "userName", column = "userName"),
            @Result(property = "productName", column = "productName")
    })
    List<Order> findAllWithDetails();
}
