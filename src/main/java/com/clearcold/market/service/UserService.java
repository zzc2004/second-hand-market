package com.clearcold.market.service;

import com.clearcold.market.bean.Order;
import com.clearcold.market.bean.Product;
import com.clearcold.market.bean.ShoppingCart;
import com.clearcold.market.bean.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public interface UserService {
    User login(String username, String password);

    List<ShoppingCart> getShoppingCartByUserId(int userId);

    boolean updateUser(User user);
    boolean updatePassword(Integer userId, String oldPass, String newPass);
    boolean register(String username, String password,String name, String phone,String email, String gender, String birthdate);

    User getNowBalance(int uid);

}
