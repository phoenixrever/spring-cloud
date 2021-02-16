package com.phoenixhell.springcloud.mapper;

import com.phoenixhell.springcloud.bean.SeataOrder;
import com.phoenixhell.springcloud.bean.SeataOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface SeataOrderMapper {
    long countByExample(SeataOrderExample example);

    int deleteByExample(SeataOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SeataOrder record);

    int insertSelective(SeataOrder record);

    List<SeataOrder> selectByExample(SeataOrderExample example);

    SeataOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SeataOrder record, @Param("example") SeataOrderExample example);

    int updateByExample(@Param("record") SeataOrder record, @Param("example") SeataOrderExample example);

    int updateByPrimaryKeySelective(SeataOrder record);

    int updateByPrimaryKey(SeataOrder record);

    int updateStatusByUserId(@Param("userId") Long userId,@Param("status") Integer status);
}