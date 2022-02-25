package com.seckill.service.impl;

import com.seckill.entity.OrderInfo;
import com.seckill.entity.User;
import com.seckill.service.GoodsService;
import com.seckill.service.OrderService;
import com.seckill.service.SeckillService;
import com.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-25 10:40
 * @Version 1.0
 **/
@Service
public class SeckillServiceImpl implements SeckillService {


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    @Override
    public OrderInfo seckill(User user, GoodsVo goodsVo) {
        //1.减库存
        int row = goodsService.reduceStock(goodsVo);
        if(row==1){
            //2.生成订单
            return orderService.createOrder(user,goodsVo);
        }
        return null;
    }
}
