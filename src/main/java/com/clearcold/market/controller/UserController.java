package com.clearcold.market.controller;

import com.clearcold.market.bean.Order;
import com.clearcold.market.bean.ShoppingCart;
import com.clearcold.market.bean.User;
import com.clearcold.market.service.OrderService;
import com.clearcold.market.service.UserService;
import com.clearcold.market.util.SHA256Util;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest req, HttpServletResponse resp,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password) {
        // 调用Service层进行登录验证
        String encryptedPwd = SHA256Util.encrypt(password);
        User user = userService.login(username, encryptedPwd);
        if (user != null) {
            // 登录成功，将用户信息存入Session
            req.getSession().setAttribute("user", user);

            // 获取购物车信息
            List<ShoppingCart> carts = userService.getShoppingCartByUserId(user.getId());
            req.getSession().setAttribute("shoppingCart", carts);

            // 如果是管理员，获取订单信息
            if ("1".equals(user.getType())) {
                List<Order> orders = orderService.getAllOrders();
                req.getSession().setAttribute("orders", orders);
            }

            return "redirect:/index"; // 跳转到首页
        } else {
            return "redirect:/loginError"; // 跳转到登录失败页面
        }
    }

    @PostMapping("/modifyUser")
    public String modifyUser(User user, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        user.setId(currentUser.getId());
        System.out.println(user.getId());
        if (userService.updateUser(user)) {
            currentUser.setName(user.getName());
            currentUser.setTel(user.getTel());
            currentUser.setEmail(user.getEmail());
            currentUser.setSignature(user.getSignature());
            session.setAttribute("user", currentUser);
            return "redirect:/modifySuccess";
        }
        return "redirect:/modifyFail";
    }

    @PostMapping("/modifyPassword")
    public String modifyPassword(
            @RequestParam("oriPassword") String oldPass,
            @RequestParam("newPassword") String newPass,
            HttpSession session) {
        String encryptedPwd = SHA256Util.encrypt(oldPass);
        String encryptedNewPwd = SHA256Util.encrypt(newPass);
        User user = (User) session.getAttribute("user");
        if (userService.updatePassword(user.getId(), encryptedPwd, encryptedNewPwd)) {
            return "redirect:/modifySuccess";
        }
        return "redirect:/modifyFail";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String birthdate = req.getParameter("birthdate");
        String encryptedPwd = SHA256Util.encrypt(password);
        return userService.register(username,encryptedPwd,name,phone,email,gender,birthdate) ? "redirect:/login" : "redirect:/error";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }

}
