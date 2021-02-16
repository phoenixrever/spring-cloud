package com.phoenixhell.springcloud.service;

import com.phoenixhell.springcloud.bean.SeataOrder;
import org.apache.ibatis.annotations.Param;

public interface OrderService {
    //新建订单
    void create(SeataOrder seataOrder);

    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
