package com.seckill.service;

import com.seckill.vo.GoodsVo;

import java.util.List;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-23 19:53
 * @Version 1.0
 **/
public interface GoodsService {

    /**
     * 商品列表
     * @return
     */
    List<GoodsVo> goodsList();

    /**
     * 商品明细
     * @param id 主键id
     * @return
     */
    GoodsVo getGoodsDetailById(Long id);
}
