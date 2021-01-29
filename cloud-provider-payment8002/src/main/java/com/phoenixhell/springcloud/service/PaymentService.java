package com.phoenixhell.springcloud.service;

import com.phoenixhell.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 8:01
 */

public interface PaymentService {

    int create(Payment payment);
    Payment getPaymentById(long id);
}
