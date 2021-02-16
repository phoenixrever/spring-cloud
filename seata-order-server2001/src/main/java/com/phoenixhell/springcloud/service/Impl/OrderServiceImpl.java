package com.phoenixhell.springcloud.service.Impl;

import com.phoenixhell.springcloud.bean.SeataOrder;
import com.phoenixhell.springcloud.bean.SeataOrderExample;
import com.phoenixhell.springcloud.mapper.SeataOrderMapper;
import com.phoenixhell.springcloud.service.AccountService;
import com.phoenixhell.springcloud.service.OrderService;
import com.phoenixhell.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private SeataOrderMapper seataOrderMapper;
    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */

    @Override
    @GlobalTransactional(name="tx_phoeixhell",rollbackFor = Exception.class)
    public void create(SeataOrder seataOrder) {
        log.info("start------------->开始新建订单");
        seataOrderMapper.insert(seataOrder);

        log.info(("start------------>订单服务调用库存做扣减"));
        System.out.println(storageService);
        storageService.decrease(seataOrder.getProductId(), seataOrder.getCount());
        log.info(("end------------>订单服务调用库存做扣减"));

        log.info("start------------->微服务调用用户账户余额扣减");
        accountService.decrease(seataOrder.getUserId(), seataOrder.getMoney());
        log.info("end------------->微服务调用用户账户余额扣减");
//        SeataOrderExample example = new SeataOrderExample();
//        SeataOrderExample.Criteria criteria = example.createCriteria();
//        criteria.andUserIdEqualTo(seataOrder.getUserId());

        //修改订单状态，从零到1代表已经完成
        log.info("start------------->修改订单状态开始");
        seataOrderMapper.updateStatusByUserId(seataOrder.getUserId(),0);
        log.info("start------------->修改订单状态结束");

        log.info("end------------->订单创建完成");
    }

    @Override
    public void update(Long userId, Integer status) {

    }
}
