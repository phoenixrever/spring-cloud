package com.phoenixhell.springcloud.springcloud.service;

import com.phoenixhell.springcloud.springcloud.entities.Payment;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 8:01
 */

public interface PaymentService {

    int create(Payment payment);
    Payment getPaymentById(long id);
}
