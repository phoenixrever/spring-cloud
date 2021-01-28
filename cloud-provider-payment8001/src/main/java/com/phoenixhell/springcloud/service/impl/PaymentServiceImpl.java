package com.phoenixhell.springcloud.service.impl;

import com.phoenixhell.springcloud.entities.Payment;
import com.phoenixhell.springcloud.mapper.PaymentMapper;
import com.phoenixhell.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 8:01
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentMapper.getPaymentById(id);
    }
}
