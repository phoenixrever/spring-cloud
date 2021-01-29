package com.phoenixhell.springcloud.mapper;

import com.phoenixhell.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author phoenixhell
 * @create 2021/1/28 0028-上午 8:00
 */

@Mapper
public interface PaymentMapper {
    int create(Payment payment);
    //param mybatis自带注解 指定数据库字段名防止不相同情况
    Payment getPaymentById(@Param("id") long id);
}
