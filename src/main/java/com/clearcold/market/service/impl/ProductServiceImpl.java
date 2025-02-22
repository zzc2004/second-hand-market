package com.clearcold.market.service.impl;

import com.clearcold.market.bean.Product;
import com.clearcold.market.dao.ProductDao;
import com.clearcold.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Transactional
    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product) > 0;
    }

    @Transactional
    public boolean removeProduct(Integer pid) {
        return productDao.removeProduct(pid) > 0;
    }

    @Override
    public ArrayList<Product> getProductsByPublisherId(int id) {
        return productDao.getProductsByPublisherId(id);
    }

    @Override
    public ArrayList<Product> getProductsByType(Integer type) {
        return productDao.selectProductsByType(type);
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return productDao.selectAllProducts();
    }

    @Override
    public Product getProductById(int pid) {
        return productDao.selectProductById(pid);
    }

    @Override
    public boolean addProduct(Product product) {
        return productDao.insertProduct(product) > 0;
    }
    @Override
    public ArrayList<Product> searchProducts(String keyword) {
        return productDao.searchProducts(keyword);
    }
}
