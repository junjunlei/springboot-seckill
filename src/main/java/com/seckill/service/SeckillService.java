package com.seckill.service;

import com.seckill.entity.OrderInfo;
import com.seckill.entity.User;
import com.seckill.vo.GoodsVo;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-25 10:39
 * @Version 1.0
 **/
public interface SeckillService {

    OrderInfo seckill(User user, GoodsVo goodsVo);
}
