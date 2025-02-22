package com.clearcold.market.controller;

import com.clearcold.market.bean.Product;
import com.clearcold.market.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    private static final int PAGE_SIZE = 4; // 每页显示的商品数量


    @PostMapping("/modifyProduct")
    public String modifyProduct(
            HttpServletRequest request) throws IOException, ServletException {

        String username = request.getParameter("publisher");
        Part imagePart = request.getPart("image");
        String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();

        String[] split = fileName.split("\\.");
        String suffix = split[split.length - 1];//获取文件后缀名

        InputStream fileContent = imagePart.getInputStream();//获取图片
        String path = request.getServletContext().getRealPath("/").split("\\\\out")[0] + "static/images/product";//强行相对路径...

        String newFileName = username + "_" + new Date().getTime() + "." + suffix;//重命名图片

        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        File newFile = new File(path + File.separator + newFileName);
        System.out.println(request.getServletContext().getRealPath("/static/images"));
        System.out.println(uploadDir);
        System.out.println(newFile.getPath());
        try (OutputStream outputStream = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }//将图片保存到指定路径下
        String path1 = request.getServletContext().getRealPath("/").split("\\\\target")[0] + "/src/main/web/static/images/product";//强行相对路径...
        newFile = new File(path1 + File.separator + newFileName);
        try (OutputStream outputStream = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }//将图片保存到指定路径下
        String id = request.getParameter("id");
        String name = request.getParameter("pname");
        System.out.println(name);
        System.out.println(request.getParameter("originalPrice"));
        double originalPrice = 10.8;
        double nowPrice = Double.parseDouble(request.getParameter("nowPrice"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String location = request.getParameter("location");
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        String type = request.getParameter("type");

        Product product = new Product(Integer.parseInt(id), name, quantity,location,originalPrice, nowPrice,  "/static/images/product/" + newFileName, description, type);

        product.setImage("/static/images/product/" + newFileName);
        if (productService.updateProduct(product)) {
            return "redirect:/modifySuccess";
        }else {
            return "redirect:/modifyFail";
        }
    }

    @RequestMapping("/removeProduct")
    public String removeProduct(@RequestParam("pid") Integer pid) {
        if (productService.removeProduct(pid)) {
            return "redirect:/removeSuccess";
        }
        return "redirect:/removeFail";
    }

    private String generateFileName(String originalName, String publisher) {
        String suffix = originalName.substring(originalName.lastIndexOf("."));
        return publisher + "_" + System.currentTimeMillis() + suffix;
    }

    @RequestMapping("/myProduct")
    public String myProducts(@RequestParam("id") Integer id, HttpServletRequest req) {
        ArrayList<Product> myProducts = productService.getProductsByPublisherId(id);
        if (!myProducts.isEmpty()) {
            req.getSession().setAttribute("myProducts", myProducts);
        }
        return "myProducts";
    }

    @GetMapping("/showByType")
    public String showByType(@RequestParam("type") Integer type, HttpSession session) {
        ArrayList<Product> typeProducts = productService.getProductsByType(type);
        if (!typeProducts.isEmpty()) {
            int total = typeProducts.size();
            int pageSize = 4;
            int maxPages = (int) Math.ceil((double) total / pageSize);
            session.setAttribute("typeProducts", typeProducts);
            session.setAttribute("type", type);
            session.setAttribute("pageNumber", 1);
            session.setAttribute("maxPages", maxPages);
        }
        return "redirect:/showProductsByType";
    }

    @GetMapping("/load")
    public String load(@RequestParam("pageNumber") int pageNumber,
                       @RequestParam("type") Integer type,
                       HttpSession session) {
        ArrayList<Product> products;
        if (type == 0) {
            products = productService.getAllProducts();
        } else {
            products = productService.getProductsByType(type);
        }

        int maxPages = (int) Math.ceil((double) products.size() / PAGE_SIZE);
        session.setAttribute("products", products);
        session.setAttribute("pageNumber", pageNumber);
        session.setAttribute("maxPages", maxPages);

        return "0".equals(type.toString()) ? "redirect:/" : "redirect:/showProductsByType";
    }

    // 处理上一页
    @GetMapping("/prev")
    public String prev(@RequestParam("pageNumber") int pageNumber,
                       @RequestParam("type") Integer type,
                       HttpSession session) {
        if (pageNumber > 1) {
            session.setAttribute("pageNumber", pageNumber - 1);
        }
        return "0".equals(type.toString()) ? "redirect:/" : "redirect:/showProductsByType";
    }

    // 处理下一页
    @GetMapping("/next")
    public String next(@RequestParam("pageNumber") int pageNumber,
                       @RequestParam("type") Integer type,
                       HttpSession session) {
        int maxPages = type == 0?(int) session.getServletContext().getAttribute("totalPages"):(int) session.getAttribute("maxPages");
        if (pageNumber + 1 <= maxPages) {
            session.setAttribute("pageNumber", pageNumber + 1);
        }
        return "0".equals(type.toString()) ? "redirect:/" : "redirect:/showProductsByType";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("pid") int pid, HttpSession session) {
        Product product = productService.getProductById(pid);
        if (product != null) {
            session.setAttribute("detail", product);
        }
        return "redirect:/productDetail";
    }

    @PostMapping("/public")
    public String handlePublic(
            HttpServletRequest request) throws IOException, ServletException {
        String username = request.getParameter("publisher");
        Part imagePart = request.getPart("image");
        String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();

        String[] split = fileName.split("\\.");
        String suffix = split[split.length - 1];//获取文件后缀名

        InputStream fileContent = imagePart.getInputStream();//获取图片
        String path = request.getServletContext().getRealPath("/").split("\\\\out")[0] + "static/images/product";//强行相对路径...

        String newFileName = username + "_" + new Date().getTime() + "." + suffix;//重命名图片

        File uploadDir = new File(path);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        File newFile = new File(path + File.separator + newFileName);
        System.out.println(request.getServletContext().getRealPath("/static/images"));
        System.out.println(uploadDir);
        System.out.println(newFile.getPath());
        try (OutputStream outputStream = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }//将图片保存到指定路径下
        String path1 = request.getServletContext().getRealPath("/").split("\\\\target")[0] + "/src/main/web/static/images/product";//强行相对路径...
        newFile = new File(path1 + File.separator + newFileName);
        try (OutputStream outputStream = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }//将图片保存到指定路径下
        String publisher = request.getParameter("publisher");
        String pname = request.getParameter("pname");
        String originalPrice = request.getParameter("originalPrice");
        String nowPrice = request.getParameter("nowPrice");
        String quantity = request.getParameter("quantity");
        String location = request.getParameter("location");
        String description = request.getParameter("description");
        String type = request.getParameter("type");
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = formatter.format(now);
        System.out.println(nowTime);

        Product product = new Product(pname,Integer.parseInt(quantity),publisher,location,Double.parseDouble(originalPrice),Double.parseDouble(nowPrice),"/static/images/product/" + newFileName,"正常",description,nowTime,type);
        productService.updateProduct(product);

        // 保存到数据库
        boolean success = productService.addProduct(product);

        return success ? "redirect:/published" : "redirect:/unpublished";
    }

    @RequestMapping(value = "/search")
    public String searchProducts(HttpServletRequest request,
                                 @RequestParam("key") String keyword) {
        ArrayList<Product> searchResult = productService.searchProducts(keyword);

        if (!searchResult.isEmpty()) {
            request.getSession().setAttribute("searchResult", searchResult);
        }else{
            request.getSession().setAttribute("searchResult", null);
        }
        return "redirect:/searchResult";
    }
}
