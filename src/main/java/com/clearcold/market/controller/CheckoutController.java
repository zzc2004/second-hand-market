package com.clearcold.market.controller;

import com.clearcold.market.bean.Order;
import com.clearcold.market.bean.Product;
import com.clearcold.market.bean.ShoppingCart;
import com.clearcold.market.bean.User;
import com.clearcold.market.service.CheckoutService;
import com.clearcold.market.service.OrderService;
import com.clearcold.market.service.ProductService;
import com.clearcold.market.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping("/checkOut")
    public String checkout(
            @RequestParam("pid") int pid,
            @RequestParam("uid") int uid,
            @RequestParam("price") double price,
            @RequestParam("quantity") int quantity,
            @RequestParam("image") String image,
            @RequestParam("type") String type,
            HttpSession session,
            RedirectAttributes ra,
            HttpServletRequest req) {

        try {
            checkoutService.checkout(pid, uid, price, quantity, image, type);
            // 更新用户余额
            User user = userService.getNowBalance(uid);
            if (user == null) {
                return "redirect:/error";
            }else {
                req.getSession().setAttribute("user", user);
            }
            ArrayList<Product> products = productService.getAllProducts();
            session.setAttribute("products", products);

            // 更新session中的购物车
            List<ShoppingCart> carts = (List<ShoppingCart>) session.getAttribute("shoppingCart");
            List<ShoppingCart> newCarts = carts.stream()
                    .filter(cart -> !image.equals(cart.getImage()))
                    .collect(Collectors.toList());
            session.setAttribute("shoppingCart", newCarts);
            List<Order> orders = orderService.getAllOrders();
            req.getSession().setAttribute("orders", orders);
            return "redirect:/buySuccess";
        } catch (RuntimeException e) {
            ra.addFlashAttribute("errorMsg", e.getMessage());
            return "redirect:/buyFail";
        }
    }
}
