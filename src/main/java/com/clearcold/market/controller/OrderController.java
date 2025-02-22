package com.clearcold.market.controller;

import com.clearcold.market.bean.Order;
import com.clearcold.market.service.OrderService;
import com.clearcold.market.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/manageOrder")
    public String manageOrder(HttpServletRequest req) {
        String type = req.getParameter("type");
        if (type.equals("1")) {
            return "manageOrderPage";
        }else {
            return "manageOrderError";
        }
    }
    @RequestMapping("/deleteOrder")
    public String deleteOrder(HttpServletRequest req) {
        String oid = req.getParameter("oid");
        if (orderService.deleteOrder(Integer.parseInt(oid))) {
            List<Order> orders = orderService.getAllOrders();
            req.getSession().setAttribute("orders", orders);
            return "/deleteSuccess";
        }else {
            return "/error";
        }
    }
}
