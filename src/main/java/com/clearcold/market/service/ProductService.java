package com.clearcold.market.service;

import com.clearcold.market.bean.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
public interface ProductService {
    boolean updateProduct(Product product);
    boolean removeProduct(Integer pid);
    ArrayList<Product> getProductsByPublisherId(int id);
    ArrayList<Product> getProductsByType(Integer type);
    public ArrayList<Product> getAllProducts();
    Product getProductById(int pid);
    boolean addProduct(Product product);
    public ArrayList<Product> searchProducts(String keyword);
}
