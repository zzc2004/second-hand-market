package com.clearcold.market.service.impl;

import com.clearcold.market.bean.Product;
import com.clearcold.market.bean.ShoppingCart;
import com.clearcold.market.dao.ProductDao;
import com.clearcold.market.dao.ShoppingCartDao;
import com.clearcold.market.service.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ShoppingCartDao shoppingCartMapper;
    @Override
    public ShoppingCart addToCart(Integer userId, Integer productId, Integer quantity, HttpSession session) {
        ArrayList<ShoppingCart> cartItems = (ArrayList<ShoppingCart>) session.getAttribute("shoppingCart");
        for (ShoppingCart cartItem : cartItems) {
            if (cartItem.getPid() == productId) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                shoppingCartMapper.updateQuantity(cartItem);
                return null;
            }
        }
        Product product = productDao.selectProductById(productId);
        if (product == null) {
            return null;
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String addTime = sdf.format(date);

        ShoppingCart cart = new ShoppingCart();
        cart.setUid(userId);
        cart.setPid(productId);
        cart.setName(product.getName());
        cart.setPrice(product.getPrice());
        cart.setPublisher(product.getPublisher());
        cart.setQuantity(quantity);
        cart.setAddTime(addTime);
        cart.setImage(product.getImage());

        int result = shoppingCartMapper.insertShoppingCart(cart);
        return result > 0 ? cart : null;
    }

    @Override
    public boolean deleteCartItem(String image, HttpSession session) {
        try {
            // 1. 删除数据库记录
            int result = shoppingCartMapper.deleteByImage(image);
            if(result == 0) return false;

            // 2. 更新session中的购物车数据
            List<ShoppingCart> carts = (List<ShoppingCart>) session.getAttribute("shoppingCart");
            List<ShoppingCart> newCarts = carts.stream()
                    .filter(cart -> !image.equals(cart.getImage()))
                    .collect(Collectors.toList());

            session.setAttribute("shoppingCart", newCarts);
            return true;

        } catch (Exception e) {
            // 事务回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new RuntimeException("删除购物车商品失败", e);
        }
    }
}
