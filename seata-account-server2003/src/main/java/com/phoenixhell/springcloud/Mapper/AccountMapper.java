package com.phoenixhell.springcloud.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
