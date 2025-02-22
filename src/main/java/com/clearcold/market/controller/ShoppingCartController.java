package com.clearcold.market.controller;

import com.clearcold.market.bean.ShoppingCart;
import com.clearcold.market.bean.User;
import com.clearcold.market.service.ShoppingCartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.ArrayList;

@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @RequestMapping("/addGoods")
    public String addToCart(
            @RequestParam("id") Integer productId,
            @RequestParam("quantity") Integer quantity,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        User user = (User) session.getAttribute("user");
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "请先登录");
            return "redirect:/login";
        }


        ShoppingCart newItem = shoppingCartService.addToCart(user.getId(), productId, quantity, session);
        if (updateSessionCart(session, newItem)) {
            return "redirect:/addSuccess";
        } else {
            redirectAttributes.addFlashAttribute("error", "添加失败");
            return "redirect:/error";
        }
    }

    private boolean updateSessionCart(HttpSession session, ShoppingCart item) {
        ArrayList<ShoppingCart> cartItems = (ArrayList<ShoppingCart>) session.getAttribute("shoppingCart");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
            session.setAttribute("shoppingCart", cartItems);
        }
        if (item == null) {
            return true;
        } else return cartItems.add(item);

    }

    @RequestMapping("/deleteGoods")
    public String deleteCartItem(
            @RequestParam("image") String image,
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        boolean success = shoppingCartService.deleteCartItem(image, session);

        if(success) {
            redirectAttributes.addFlashAttribute("message", "删除成功");
            return "redirect:/deleteSuccess";
        } else {
            redirectAttributes.addFlashAttribute("error", "删除失败");
            return "redirect:/error";
        }
    }
}
