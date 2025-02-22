package com.clearcold.market.service;

import com.clearcold.market.bean.ShoppingCart;
import jakarta.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ShoppingCartService {
    ShoppingCart addToCart(Integer userId, Integer productId, Integer quantity, HttpSession session);
    boolean deleteCartItem(String image, HttpSession session);
}
