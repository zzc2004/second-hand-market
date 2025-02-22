package com.clearcold.market.dao;

import com.clearcold.market.bean.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductDao {
    @Update("UPDATE products " +
            "        SET pname=#{name}, oriPrice=#{oriPrice}, pprice=#{price}, " +
            "            pquantity=#{quantity}, location=#{location}, path=#{image}," +
            "            description=#{description}, type=#{type}" +
            "        WHERE pid=#{id}")
    @Results({
            @Result(property = "id", column = "pid"),
            @Result(property = "name", column = "pname"),
            @Result(property = "image", column = "path"),
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "price", column = "pprice"),

    })
    int updateProduct(Product product);
    @Update("update products set status='下架' where pid = #{pid}")
    @Results({
            @Result(property = "id", column = "pid"),
            @Result(property = "name", column = "pname"),
            @Result(property = "image", column = "path"),
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "price", column = "pprice"),

    })
    int removeProduct(@Param("pid") Integer pid);

    @Select("select * from products where publisher = (select uname from users where uid = #{id}) and status = '正常' and pquantity>0")
    @Results({
            @Result(property = "id", column = "pid"),
            @Result(property = "name", column = "pname"),
            @Result(property = "image", column = "path"),
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "price", column = "pprice"),

    })
    ArrayList<Product> getProductsByPublisherId(int id);

    @Select("SELECT * FROM products WHERE type = #{type} AND pquantity > 0 AND status = '正常'")
    @Results({
            @Result(property = "id", column = "pid"),
            @Result(property = "name", column = "pname"),
            @Result(property = "image", column = "path"),
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "price", column = "pprice"),

    })
    ArrayList<Product> selectProductsByType(@Param("type") Integer type);

    @Select("SELECT * FROM products WHERE pquantity > 0 AND status = '正常'")
    @Results({
            @Result(property = "id", column = "pid"),
            @Result(property = "name", column = "pname"),
            @Result(property = "image", column = "path"),
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "price", column = "pprice"),

    })
    ArrayList<Product> selectAllProducts();

    @Select("SELECT * FROM products WHERE pid = #{pid} AND status = '正常'")
    @Results({
            @Result(property = "id", column = "pid"),
            @Result(property = "name", column = "pname"),
            @Result(property = "image", column = "path"),
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "price", column = "pprice"),

    })
    Product selectProductById(@Param("pid") int pid);

    @Update("UPDATE products SET pquantity = pquantity - #{quantity} WHERE pid = #{pid} AND pquantity >= #{quantity}")
    @Results({
            @Result(property = "id", column = "pid"),
            @Result(property = "name", column = "pname"),
            @Result(property = "image", column = "path"),
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "price", column = "pprice"),
    })
    int reduceStock(@Param("pid") int pid, @Param("quantity") int quantity);

    @Insert("INSERT INTO products(pname, oriPrice, pprice, pquantity, publisher, " +
            "location, publish_time, status, path, description, type) " +
            "VALUES(#{name}, #{oriPrice}, #{price}, #{quantity}, #{publisher}, " +
            "#{location}, #{time}, #{status}, #{image}, #{description}, #{type})")
    @Results({
            @Result(property = "id", column = "pid"),
            @Result(property = "name", column = "pname"),
            @Result(property = "image", column = "path"),
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "price", column = "pprice"),
            @Result(property = "time", column = "publish_time")
    })
    int insertProduct(Product product);

    @Select("SELECT * FROM products WHERE (pname LIKE CONCAT('%', #{key}, '%') OR type LIKE CONCAT('%', #{key}, '%')) AND status = '正常'")
    @Results({
            @Result(property = "id", column = "pid"),
            @Result(property = "name", column = "pname"),
            @Result(property = "image", column = "path"),
            @Result(property = "quantity", column = "pquantity"),
            @Result(property = "price", column = "pprice"),
            @Result(property = "time", column = "publish_time")
    })
    ArrayList<Product> searchProducts(@Param("key") String keyword);
}
