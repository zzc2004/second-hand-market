package com.clearcold.market.service;

import com.clearcold.market.bean.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OrderService {
    boolean deleteOrder(Integer orderId);
    List<Order> getAllOrders();

}
