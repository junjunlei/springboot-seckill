package com.seckill.service;

import com.seckill.entity.OrderInfo;
import com.seckill.entity.User;
import com.seckill.vo.GoodsVo;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-24 19:55
 * @Version 1.0
 **/
public interface OrderService {
    OrderInfo createOrder(User user, GoodsVo goodsVo);
}
