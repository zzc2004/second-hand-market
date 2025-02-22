package com.clearcold.market.service.impl;

import com.clearcold.market.bean.Order;
import com.clearcold.market.dao.OrderDao;
import com.clearcold.market.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public boolean deleteOrder(Integer orderId) {
        return orderDao.deleteOrder(orderId);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAllOrders();
    }
}
