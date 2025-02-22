package com.clearcold.market.service.impl;

import com.clearcold.market.bean.Order;
import com.clearcold.market.bean.ShoppingCart;
import com.clearcold.market.bean.User;
import com.clearcold.market.dao.OrderDao;
import com.clearcold.market.dao.ShoppingCartDao;
import com.clearcold.market.dao.UserDao;
import com.clearcold.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public User login(String username, String password) {
        return userDao.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public List<ShoppingCart> getShoppingCartByUserId(int userId) {
        return shoppingCartDao.findByUserId(userId);
    }


    @Transactional
    public boolean updateUser(User user) {
        return userDao.updateUser(user) > 0;
    }

    @Transactional
    public boolean updatePassword(Integer userId, String oldPass, String newPass) {
        return userDao.updatePassword(userId, newPass, oldPass) > 0;
    }

    @Override
    public boolean register(String username, String password,String name, String phone,String email, String gender, String birthdate) {
        return userDao.register(username,password,name,phone,email,gender,birthdate);
    }

    @Override
    public User getNowBalance(int uid) {
        return userDao.getUserById(uid);
    }

}
