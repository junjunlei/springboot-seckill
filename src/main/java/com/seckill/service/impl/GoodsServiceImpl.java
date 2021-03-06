package com.seckill.service.impl;

import com.seckill.mapper.GoodsMapper;
import com.seckill.service.GoodsService;
import com.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zhanbo
 * @Description TODO
 * @Date 2022-02-23 19:53
 * @Version 1.0
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsVo> goodsList() {
        return goodsMapper.goodsList();
    }

    @Override
    public GoodsVo getGoodsDetailById(Long id) {
        return goodsMapper.getGoodsDetailById(id);
    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    @Override
    public int reduceStock(GoodsVo goodsVo) {
        return goodsMapper.reduceStock(goodsVo.getId());
    }
}
