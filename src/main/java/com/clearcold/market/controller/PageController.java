package com.clearcold.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/personal")
    public String personalPage() {
        return "personal";
    }

    @RequestMapping("/public")
    public String publicPage() {
        return "public";
    }

    @RequestMapping("/shoppingCart")
    public String shoppingCartPage() {
        return "shoppingCart";
    }

    @RequestMapping("/modifyPassword")
    public String modifyPasswordPage() {
        return "modifyPasswordPage";
    }

    @RequestMapping("/modifyUser")
    public String modifyUserPage() {
        return "modifyUser";
    }

    @RequestMapping("/myProducts")
    public String myProductsPage() {
        return "myProducts";
    }
    @RequestMapping("/showProductsByType")
    public String showProductsByTypePage() {
        return "showProductsByType";
    }
    @RequestMapping("/productDetail")
    public String productDetailPage() {
        return "productDetail";
    }
    @RequestMapping("/modifyProduct")
    public String modifyProductPage() {
        return "modifyProduct";
    }
    @RequestMapping("/published")
    public String publishedPage() {
        return "published";
    }
    @RequestMapping("/unpublished")
    public String unpublishedPage() {
        return "unpublished";
    }
    @RequestMapping("/removeSuccess")
    public String removeSuccessPage() {
        return "removeSuccess";
    }
    @RequestMapping("/removeFail")
    public String removeFailPage() {
        return "removeFail";
    }
    @RequestMapping("/modifySuccess")
    public String modifySuccessPage() {
        return "modifySuccess";
    }
    @RequestMapping("/modifyFail")
    public String modifyFailPage() {
        return "modifyFail";
    }
    @RequestMapping("/buySuccess")
    public String buySuccessPage() {
        return "buySuccess";
    }
    @RequestMapping("/buyFail")
    public String buyFailPage() {
        return "buyFail";
    }
    @RequestMapping("/loginError")
    public String loginErrorPage() {
        return "loginError";
    }
    @RequestMapping("/addSuccess")
    public String addSuccessPage() {
        return "addSuccess";
    }
    @RequestMapping("/error")
    public String errorPage() {
        return "error";
    }
    @RequestMapping("/deleteSuccess")
    public String deleteSuccessPage() {
        return "deleteSuccess";
    }
    @RequestMapping("/searchResult")
    public String searchResultPage() {
        return "searchResult";
    }
    @RequestMapping("/manageOrderPage")
    public String manageOrderPage() {
        return "manageOrderPage";
    }
    @RequestMapping("/register")
    public String registerPage() {
        return "register";
    }
    @RequestMapping("/modifyPasswordPage")
    public String modifyPasswordPagePage() {
        return "modifyPasswordPage";
    }
}
