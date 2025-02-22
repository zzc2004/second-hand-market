package com.clearcold.market.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CheckoutService {
    public void checkout(int pid, int uid, double price, int quantity, String image, String type);
}
