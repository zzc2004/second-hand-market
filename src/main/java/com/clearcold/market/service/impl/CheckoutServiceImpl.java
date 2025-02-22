package com.clearcold.market.service.impl;

import com.clearcold.market.bean.Order;
import com.clearcold.market.dao.OrderDao;
import com.clearcold.market.dao.ProductDao;
import com.clearcold.market.dao.ShoppingCartDao;
import com.clearcold.market.dao.UserDao;
import com.clearcold.market.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Transactional(rollbackFor = Exception.class)
    public void checkout(int pid, int uid, double price, int quantity, String image, String type) {
        double total = price * quantity;
        if (userDao.updateBalance(uid, total) == 0) {
            throw new RuntimeException("余额不足");
        }
//        System.out.println("One");

        // 2. 扣减库存
        if (productDao.reduceStock(pid, quantity) == 0) {
            throw new RuntimeException("库存不足");
        }
//        System.out.println("Two");

        // 3. 创建订单
        Order order = new Order();
        order.setPid(pid);
        order.setUid(uid);
        order.setQuantity(quantity);
        order.setPrice(total);
        Date time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(time);
        order.setTime(date);
        order.setStatus("正常");
        if (orderDao.createOrder(order) == 0) {
            throw new RuntimeException("订单创建失败");
        }
//        System.out.println("Three");

        // 4. 清理购物车
        if ("1".equals(type)) {
            if (shoppingCartDao.removeFromCart(uid, image) == 0) {
                throw new RuntimeException("购物车清理失败");
            }
        }
//        System.out.println("Four");
    }
}
