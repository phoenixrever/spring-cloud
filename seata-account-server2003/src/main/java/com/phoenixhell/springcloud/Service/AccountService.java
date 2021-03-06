package com.phoenixhell.springcloud.Service;


import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public interface AccountService {

    /**
     * 扣减账户余额
     */
    void decrease(Long userId, BigDecimal money);
}
