package com.phoenixhell.spingcloud.service;

/**
 * @author phoenixhell
 * @create 2021/1/31 0031-下午 2:28
 */

public interface HystrixPaymentService {
    public String PaymentInfo_OK(Integer id);
    public String PaymentInfo_Timeout(Integer id);
}
